<%-- 
    Document   : index
    Author     : joemertz
    Source     : https://gist.github.com/joemertz/449a26fe12ec1ae901e0
--%>

<p> Provide your eye color, hair color, hair length and age, and this app
    will find an anime character that looks like you by screen scraping the
    <a href="http://animecharactersdatabase.com/" target="_blank">
        <img src="http://ami.animecharactersdatabase.com/hosted/Red2.png"></a> 
</p>
<FORM NAME=mainsearch ACTION="getAnimeDoppleganger" method="post">
    <TABLE class="formstyle">
        <TR>
            <TH>Eye Color</TH>
            <TH>Hair Color</TH>
            <TH>Hair Length</TH>
            <TH>Apparent Age</TH>
        <TR>
            <TD>
                <select  name=eye_color>
                    <option value="0" selected='selected'> Eye Color </option>
                    <option value="1"> Black </option>
                    <option value="3"> Blue </option>
                    <option value="4"> Brown </option>
                    <option value="5"> Green </option>
                    <option value="6"> Gray </option>
                    <option value="7"> Orange </option>
                    <option value="8"> Purple </option>
                    <option value="9"> Red </option>
                    <option value="10"> White </option>
                    <option value="11"> Yellow </option>
                    <option value="12"> Pink </option>
                    <option value="14"> Blue-Green </option>
                    <option value="20"> Not Visible </option>
                </select>
            </TD>
            <TD>
                <select  name=hair_color>
                    <option value="0" selected='selected'> Hair Color </option>
                    <option value="1"> Black </option>
                    <option value="2"> Blonde/Yellow </option>
                    <option value="3"> Blue </option>
                    <option value="4"> Brown </option>
                    <option value="5"> Green </option>
                    <option value="6"> Gray </option>
                    <option value="7"> Orange </option>
                    <option value="8"> Purple </option>
                    <option value="9"> Red </option>
                    <option value="10"> White </option>
                    <option value="12"> Pink </option>
                    <option value="13"> Maroon </option>
                    <option value="14"> Blue-Green </option>
                    <option value="20"> Not Visible </option>
                </select>
            </TD>
            <TD>
                <select  name=hair_length>
                    <option value="0" selected='selected'> Hair Length </option>
                    <option value="1"> No Hair </option>
                    <option value="2"> To Ears </option>
                    <option value="3"> To Neck </option>
                    <option value="4"> To Shoulders </option>
                    <option value="5"> To Chest </option>
                    <option value="6"> To Waist </option>
                    <option value="7"> Past Waist </option>
                    <option value="8"> Hair Up / Indeterminate </option>
                </select>
            </TD>
            <TD>
                <select  name=age>
                    <option value="0" selected='selected'> Apparent Age </option>
                    <option value="1"> Child </option>
                    <option value="3"> Teen </option>
                    <option value="4"> Adult </option>
                    <option value="5"> Senior </option>
                    <option value="6"> Ageless </option>
                </select>
            </TD>
        </tr>
        <tr>
            <td colspan="4" style="text-align: center">
                <input class="submitstyle" type="submit" value="Find my doppelganger"/>
            </td>
        </tr>
    </TABLE>

</FORM>
