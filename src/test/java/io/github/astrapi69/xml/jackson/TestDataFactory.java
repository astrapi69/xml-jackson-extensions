package io.github.astrapi69.xml.jackson;

import io.github.astrapi69.test.object.Club;
import io.github.astrapi69.test.object.Company;
import io.github.astrapi69.test.object.Employee;
import io.github.astrapi69.test.object.Factory;
import io.github.astrapi69.test.object.Member;
import io.github.astrapi69.test.object.Person;
import io.github.astrapi69.test.object.enumtype.Gender;

import java.util.ArrayList;
import java.util.List;

public class TestDataFactory
{

	public static Club newClub()
	{
		List members = new ArrayList<Member>();

		members.add(Member.builder().name("Lea").gender(Gender.FEMALE).married(Boolean.FALSE)
			.nickname("princess").build());

		members.add(Member.builder().name("Luke").gender(Gender.MALE).married(Boolean.FALSE)
			.nickname("wannabejedi").build());

		Club club = new Club();
		club.setMembers(members);
		club.setLocation("Greece/Katerini");
		club.setName("StarPiece");
		return club;
	}

	public static Factory newFactory()
	{
		List employees = new ArrayList<Employee>();

		Employee employee1 =
		Employee.builder().id("1")
			.person(Person.builder().name("Lea").gender(Gender.FEMALE).married(Boolean.FALSE).build()).build();

		employees.add(employee1);

		Employee employee2 = new Employee();
		Employee.builder().id("2")
			.person(Person.builder().name("Luke").gender(Gender.MALE).married(Boolean.FALSE).build()).build();

		employees.add(employee2);

		Factory company = new Factory();
		company.setEmployees(employees);
		company.setLocation("Greece/Katerini");
		company.setName("StarPiece");
		return company;
	}
}
