/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bhavya.project1.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author bhavya
 */
public class DopplegangerRequestModel {

    private String eyeColor;
    private String hairColor;
    private String hairLength;
    private String apparentAge;

    public DopplegangerRequestModel(String eyeColor, String hairColor, String hairLength, String apparentAge) {
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.hairLength = hairLength;
        this.apparentAge = apparentAge;
    }
    
    private List<CharacterExtractor> makeARequestAndGetCharacters() throws MalformedURLException, IOException {
        String requestURL = "http://www.animecharactersdatabase.com/sresults.php?"
                + "eye_color=" + this.eyeColor
                + "&hair_color=" + this.hairColor
                + "&hair_length=" + this.hairLength
                + "&age=" + this.apparentAge
                + "&mymax=100";

        // http://stackoverflow.com/questions/238547/how-do-you-programmatically-download-a-webpage-in-java
        URL url;
        InputStream is = null;
        BufferedReader br;
        String line;
        String characterPage = null, thumbNailImage = null;
        List<CharacterExtractor> results = new ArrayList<CharacterExtractor>();
        boolean foundResults = false;

        try {
            url = new URL(requestURL);
            is = url.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            String lineX;
            while ((lineX = br.readLine()) != null) {
                line = lineX.toLowerCase().trim();
                if (line.contains("tile1")) {
                    // All lines following this will have results
                    foundResults = true;
                } else if (foundResults && line.contains("div")) {
                    // We can stop now
                    foundResults = false;
                } else if (foundResults && line.contains("a href")) {
                    String characterPagePrefix = line.substring(line.indexOf("\"") + 1);
                    characterPage = characterPagePrefix.substring(0, characterPagePrefix.indexOf("\""));
                    String thumbNailImagePrefix = line.substring(line.indexOf("img style=\"width: 150px;\" src=\"") + 31);
                    thumbNailImage = thumbNailImagePrefix.substring(0, thumbNailImagePrefix.indexOf("\""));
                    CharacterExtractor character = new CharacterExtractor(characterPage, thumbNailImage);
                    results.add(character);
                }
            }
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException ioe) {
                // nothing to see here
            }
        }

        return results;
    }

    private Doppleganger constructDoppelganerFromCharacterPage(String id, String thumbNailImage) throws IOException {
        String requestURL = "http://www.animecharactersdatabase.com/" + id;
        String name = null, fullSizeImage = null;

        // http://stackoverflow.com/questions/238547/how-do-you-programmatically-download-a-webpage-in-java
        URL url;
        InputStream is = null;
        BufferedReader br;
        String line;
        boolean foundName = false;

        try {
            url = new URL(requestURL);
            is = url.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            String lineX;
            while ((lineX = br.readLine()) != null) {
                line = lineX.toLowerCase().trim();
                if (line.contains("title>")) {
                    name = line.substring(line.indexOf("title") + 6, line.indexOf("|")).trim();
                    foundName = true;
                } else if (foundName && line.contains("img alt=\"" + name + "\" src=\"")) {
                    String fullSizeImagePrefix = line.substring(line.indexOf("img alt=\"" + name + "\" src=\"") + (16+name.length()));
                    fullSizeImage = fullSizeImagePrefix.substring(0, fullSizeImagePrefix.indexOf("\" style=\"max-width: 800px;\"><br><br>"));
                    foundName = false;
                }
            }
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException ioe) {
                // nothing to see here
            }
        }
        
        Doppleganger doppleganger = new Doppleganger(name, fullSizeImage, thumbNailImage);
        return doppleganger;
    }

    public Doppleganger findRandomDoppleganger() throws IOException {
        Doppleganger doppleganger;
        List<CharacterExtractor> characters = makeARequestAndGetCharacters();
        
        if (characters == null || characters.isEmpty()) {
            return null;
        }

        // We can choose one character randomly from these pages
        // http://stackoverflow.com/questions/363681/generating-random-integers-in-a-range-with-java
        Random rand = new Random();
        int randomNum = rand.nextInt(characters.size());

        CharacterExtractor character = characters.get(randomNum);
        doppleganger = constructDoppelganerFromCharacterPage(character.getCharacterDetailsURL(), character.getThumbNailImage());

        return doppleganger;
    }

}
