package net.codejava;

import java.util.List;

import net.codejava.EmployeeVO;

public interface EmployeeDAO 
{
	public List<EmployeeVO> getAllEmployees();
}