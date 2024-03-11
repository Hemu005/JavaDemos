package com.doctorapp.client;

import com.doctorapp.exception.DoctorNotFoundException;
import com.doctorapp.model.Doctor;
import com.doctorapp.model.Specialization;
import com.doctorapp.service.DoctorServiceImpl;
import com.doctorapp.service.IDoctorService;

import java.util.List;
import java.util.Scanner;

public class User {
    public static void main(String[] args) throws DoctorNotFoundException {
        IDoctorService service=new DoctorServiceImpl();
        Specialization specialization=Specialization.DERMA;
        String speciality=Specialization.DERMA.getSpeciality();
        Scanner sc=new Scanner(System.in);

        service.addDoctor(new Doctor("Praveen","PEDIATRICIAN",1400,9,6));
        service.addDoctor(new Doctor("Krishna","NEUROLOGIST",1450,8,9));
        service.addDoctor(new Doctor("Kavitha","RADIOLOGIST",1800,8,7));
        service.addDoctor(new Doctor("Ram","GENERAL PHYSICIAN",2500,9,14));
        service.addDoctor(new Doctor("Shalini","DERMATOLOGIST",2300,10,11));

        service.updateDoctor(2,1050);
        service.deleteDoctor(3);

        System.out.println("Enter your choice:");
        System.out.println("1.Speciality "+"2.Speciality and Exp "+"3.Speciality and less fees "+
                           "4.Speciality and ratings "+"5.Speciality and name");
        int choice=sc.nextInt();
        switch (choice){
            case 1:
                 System.out.println("Enter the Speciality:");
                 String spl=sc.next();
                 Specialization sp=Specialization.valueOf(spl);
                 List<Doctor>doctors=service.findBySpeciality(sp.getSpeciality());
                 for (Doctor doctor:doctors)
                     System.out.println(doctor);
                  break;
            case 2:
                System.out.println("Enter speciality and Exp");
                String spl1=sc.next();
                int exp=sc.nextInt();
                Specialization sp1=Specialization.valueOf(spl1);
                List<Doctor>doctors1=service.findBySpecialityAndExp(sp1.getSpeciality(),exp);
                for (Doctor doctor:doctors1)
                    System.out.println(doctor);
                break;
            case 3:
                System.out.println("Enter speciality and Fees less than");
                String spl2=sc.next();
                int fees=sc.nextInt();
                Specialization sp2=Specialization.valueOf(spl2);
                List<Doctor>doctors2=service.findBySpecialityAndLessFees(sp2.getSpeciality(),fees);
                for (Doctor doctor:doctors2)
                    System.out.println(doctor);
                break;
            case 4:
                System.out.println("Enter speciality and rating");
                String spl3=sc.next();
                int rate=sc.nextInt();
                Specialization sp3=Specialization.valueOf(spl3);
                List<Doctor>doctors3=service.findBySpecialityAndRatings(sp3.getSpeciality(),rate);
                for (Doctor doctor:doctors3)
                    System.out.println(doctor);
                break;
            case 5:
                System.out.println("Enter speciality and Name");
                String spl4=sc.next();
                String name=sc.next();
                Specialization sp4=Specialization.valueOf(spl4);
                List<Doctor>doctors4=service.findBySpecialityAndNameContains(sp4.getSpeciality(),name);
                for (Doctor doctor:doctors4)
                    System.out.println(doctor);
                break;
    }
    }
}

