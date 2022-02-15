package com.example.demo.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test_details")
public class TestDetailsModel {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public int id;
	public String test_name;
	public String test_code;
	public String owner_name;
	public String duration;
	public String from_date;
	public String to_date;
	public String start_time;
	public String end_time;
	public String file_name;
	public String total_questions;
	public String test_description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTest_name() {
		return test_name;
	}
	public void setTest_name(String test_name) {
		this.test_name = test_name;
	}
	public String getTest_code() {
		return test_code;
	}
	public void setTest_code(String test_code) {
		this.test_code = test_code;
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getFrom_date() {
		return from_date;
	}
	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}
	public String getTo_date() {
		return to_date;
	}
	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getTotal_questions() {
		return total_questions;
	}
	public void setTotal_questions(String total_questions) {
		this.total_questions = total_questions;
	}
	public String getTest_description() {
		return test_description;
	}
	public void setTest_description(String test_description) {
		this.test_description = test_description;
	}
	@Override
	public String toString() {
		return "TestDetailsModel [id=" + id + ", test_name=" + test_name + ", test_code=" + test_code + ", owner_name="
				+ owner_name + ", duration=" + duration + ", from_date=" + from_date + ", to_date=" + to_date
				+ ", start_time=" + start_time + ", end_time=" + end_time + ", file_name=" + file_name
				+ ", total_questions=" + total_questions + ", test_description=" + test_description + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(duration, end_time, file_name, from_date, id, owner_name, start_time, test_code,
				test_description, test_name, to_date, total_questions);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestDetailsModel other = (TestDetailsModel) obj;
		return Objects.equals(duration, other.duration) && Objects.equals(end_time, other.end_time)
				&& Objects.equals(file_name, other.file_name) && Objects.equals(from_date, other.from_date)
				&& id == other.id && Objects.equals(owner_name, other.owner_name)
				&& Objects.equals(start_time, other.start_time) && Objects.equals(test_code, other.test_code)
				&& Objects.equals(test_description, other.test_description)
				&& Objects.equals(test_name, other.test_name) && Objects.equals(to_date, other.to_date)
				&& Objects.equals(total_questions, other.total_questions);
	}
	
	
}
