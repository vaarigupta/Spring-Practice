package com.practice.auth.learn.model;

import lombok.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

   private String userId;
   private  String username;
   private  String email;
}
