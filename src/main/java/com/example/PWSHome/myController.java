/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.PWSHome;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Asus
 */
@Controller
public class myController {
    
    @RequestMapping("/senddata")
    public String olahData(
            @RequestParam("nmlngkp") String namalengkap,
            @RequestParam("nmpgln") String namapanggilan,
            @RequestParam("tgl") @DateTimeFormat(pattern = "yyyy-MM-dd") Date tanggal,
            @RequestParam("ft") MultipartFile file, Model model) throws 
            IOException, ParseException
    {
        return "idcard";
    }
}
