package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Main {
	public String id;
	public String type;
	public String name;
	public Image image;
	public Thumbnail thumbnail;
}
