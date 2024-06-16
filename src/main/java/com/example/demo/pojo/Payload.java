package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payload {
	private String id;
	private String type;
	private String name;
	private double ppu;
	private Batters batters;
	private List<Topping> topping;
}