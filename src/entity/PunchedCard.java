/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author admin
 */
public class PunchedCard implements Serializable {
    
    private int punched_id;
    private String punched_status;
    private Date clock_in;
    private Date clock_out;
    private Staff staff;
    
}
