/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bhavya.project1.task4;

/**
 *
 * @author bhavya
 */
public class CharacterExtractor {

    private String characterDetailsURL;
    private String thumbNailImage;

    public CharacterExtractor(String characterDetailsURL, String thumbNailImage) {
        this.characterDetailsURL = characterDetailsURL;
        this.thumbNailImage = thumbNailImage;
    }

    public String getCharacterDetailsURL() {
        return characterDetailsURL;
    }

    public void setCharacterDetailsURL(String characterDetailsURL) {
        this.characterDetailsURL = characterDetailsURL;
    }

    public String getThumbNailImage() {
        return thumbNailImage;
    }

    public void setThumbNailImage(String thumbNailImage) {
        this.thumbNailImage = thumbNailImage;
    }
}
