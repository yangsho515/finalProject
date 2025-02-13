package com.example.demo.gwang.collection;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

public class Manager {
	private List<People> peopleList = new ArrayList<People>();
	
	public Manager() {
		
		People people1 = new Student("김장철","14","남자","1","1","11");
		People people2 = new Student("유관순","14","남자","1","1","11");
		People people3 = new Student("강감찬","14","남자","1","1","11");
		People people4 = new Student("이방원","14","남자","1","1","11");
		People people5 = new Student("이성계","14","남자","1","1","11");
		
		
		
		// 컴파일타임              실행타임           
//		people1.setName("김장철");
//		people1.setAge("40");
//		people1.setSex("남자");
//		((Student)people1).setGrade("3");
//		((Student)people1).setClassNo("1");
//		((Student)people1).setNo("11");
		
		this.create(people1);
		this.create(people2);
		this.create(people3);
		this.create(people4);
		this.create(people5);
		
		
		
		People people6 = new Teacher("이영어","33","여자","정교사","담임");
		People people7 = new Teacher("한국어","31","남자","정교사","담임");
		People people8 = new Teacher("박수학","30","남자","정교사","담임");
		
		this.create(people6);
		this.create(people7);
		this.create(people8);
		
	}
	
	public void printPeopleList() {
		System.out.println("### 전체 출력 시작");
		for(People people : peopleList) {
			System.out.println(people);
		}
		System.out.println("### 전체 출력 끝");
	}
	
	public void pirntStudentList() {
		System.out.println("### 학생만 출력 시작 ###");
		for (People people : peopleList) {
			if(people instanceof Student) {
				System.out.println(people);
			}
		}
		System.out.println("### 학생만 출력 종료 ###");
		
	}
	
	public void pirntTeacherList() {
		System.out.println("### 교사만 출력 시작 ###");
		for (People people : peopleList) {
			if(people instanceof Teacher) {
				System.out.println(people);
			}
		}
		System.out.println("### 교사만 출력 종료 ###");
		
	}
	
	public void create(People people) {
		peopleList.add(people);
	}
	
	// 이름이 유일키로 약속하고, 해당 사람을 찾을 수 있도록 완성하세요.
	public People retrieve(People people) {
		People findPeople = null;
		
//		for (People inpeople : peopleList) {
//			if(inpeople.getName().equals(people.getName())) {
//				findPeople = inpeople;
//			}
//		}
		
		int index = peopleList.indexOf(people);
		if(index > -1) {
			findPeople = peopleList.get(index);
		}
		return findPeople;
	}
	
	
	public int update(People people) {
		int cnt = 0;
//		People findPeople = null;
//		for (People inPeople : peopleList) {
//			if(inPeople.getName().equals(people.getName())) {
//				findPeople = inPeople;
//				cnt++;
//			}
//		}
		
//		peopleList.remove(people);
//		peopleList.add(people);
		People findPeople = this.retrieve(people);
		if(findPeople != null) {
//			findPeople.setName(people.getName());
//			findPeople.setAge(people.getAge());
			BeanUtils.copyProperties(people, findPeople);
		}
		
		
		return cnt;
	}
	
	public int delete(People people) {
		int cnt =0;
		if(peopleList.remove(people)) {
			cnt++;
		}
		return cnt;
	}
	
	
	public static void main(String[] args) {
		Manager manager = new Manager();
		People people = new Student();
		people.setName("강감찬");
		
		People findPeople = manager.retrieve(people);
		System.out.println("findPeople: " + findPeople);
		
		people = new Student("강감찬","14","여자","3","11","3");
		int cnt = manager.update(people);
		System.out.println("cnt: " +cnt);
		
		findPeople = manager.retrieve(people);
		System.out.println("findPeople:" +findPeople);
		
		System.out.println(manager.delete(people));
		manager.printPeopleList();
		
		
//		manager.printPeopleList();
		
		
		
//		manager.printPeopleList();
		
		
		
		
	}

}
