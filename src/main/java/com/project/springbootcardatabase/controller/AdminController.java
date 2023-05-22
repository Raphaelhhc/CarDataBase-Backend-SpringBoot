package com.project.springbootcardatabase.controller;

import com.project.springbootcardatabase.requestmodels.AddCarRequest;
import com.project.springbootcardatabase.requestmodels.EditCarRequest;
import com.project.springbootcardatabase.service.AdminService;
import com.project.springbootcardatabase.utils.ExtractJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("https://web-cardatabase-react.onrender.com")
@RestController
@RequestMapping("/api")
public class AdminController {

    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/secure/admin/add/car")
    public void postCar(@RequestHeader(value="Authorization") String token,
                        @RequestBody AddCarRequest addCarRequest) throws Exception {

        String admin = ExtractJWT.payloadJWTExtraction(token, "\"userType\"");

        if (admin == null || !admin.equals("admin")) {
            throw new Exception("Administration page only");
        }

        adminService.postCar(addCarRequest);

    }

    @PutMapping("/secure/admin/update/car")
    public void updateCarInfo(@RequestHeader(value="Authorization") String token,
                              @RequestBody EditCarRequest editCarRequest,
                              @RequestParam Long carId) throws Exception {

        String admin = ExtractJWT.payloadJWTExtraction(token, "\"userType\"");

        if (admin == null || !admin.equals("admin")) {
            throw new Exception("Administration page only");
        }

        adminService.updateCarInfo(carId, editCarRequest);

    }

    @DeleteMapping("/secure/admin/delete/car")
    public void deleteCar(@RequestHeader(value="Authorization") String token,
                          @RequestParam Long carId) throws Exception {

        String admin = ExtractJWT.payloadJWTExtraction(token, "\"userType\"");

        if (admin == null || !admin.equals("admin")) {
            throw new Exception("Administration page only");
        }

        adminService.deleteCar(carId);

    }

}
