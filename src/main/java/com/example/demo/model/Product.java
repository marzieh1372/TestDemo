package com.example.demo.model;




import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "interview_product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column()
	private long id;

	@Column
	private String name;
	@Column
	private Integer price;

	public long getId() {

		return id;
	}

	public void setId(long id) {

		this.id = id;
	}


	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}


	public Integer getPrice() {

		return price;
	}

	public void setPrice(Integer price) {

		this.price = price;
	}


	@Override
	public String toString() {

		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
}
