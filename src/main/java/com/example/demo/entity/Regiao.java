/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.demo.entity;

/**
 *
 * @author Metila
 */
public class Regiao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

     @Column(nullable = false)
     private String nome;
  
     

}
