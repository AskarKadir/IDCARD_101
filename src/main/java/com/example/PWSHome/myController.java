/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.PWSHome;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.tomcat.util.codec.binary.Base64;
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
    
    @RequestMapping("/input")
    public String olahData(
            @RequestParam("nmlngkp") String namalengkap,
            @RequestParam("nmpgln") String namapanggilan,
            @RequestParam("tgl") @DateTimeFormat(pattern = "yyyy-MM-dd") Date tanggal,
            @RequestParam("image") MultipartFile file, 
            Model model) throws 
            IOException, ParseException
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        String konvtgl = formatter.format(tanggal);
        
        String blob = Base64.encodeBase64String(file.getBytes());
        String gambar = "data:image/jpeg;base64,".concat(blob);
        
        
        model.addAttribute("nama", namalengkap);
        model.addAttribute("panggilan", namapanggilan);
        model.addAttribute("tanggal", konvtgl);
        model.addAttribute("fotoorang", gambar);
        return "idcard";
    }
}
