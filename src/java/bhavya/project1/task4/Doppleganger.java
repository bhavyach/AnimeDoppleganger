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
public class Doppleganger {
    
    private final String name;
    private final String fullImage;
    private final String thumbNailImage;
    
    public Doppleganger(String name, String fullImage, String thumbNailImage) {
        this.name = name;
        this.fullImage = fullImage;
        this.thumbNailImage = thumbNailImage;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getFullImage() {
        return this.fullImage;
    }
    
    public String getThumbNailImage() {
        return this.thumbNailImage;
    }
    
}
