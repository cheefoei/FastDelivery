/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author admin
 */
public class PunchedCard {
    private int punched_id;
    private String punched_status;
    private DateFormat clock_in = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private DateFormat clock_out =new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        
    
}
