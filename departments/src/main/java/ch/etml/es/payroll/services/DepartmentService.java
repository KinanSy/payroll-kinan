package ch.etml.es.payroll.services;

import ch.etml.es.payroll.config.EmployeeServiceProperties;
import ch.etml.es.payroll.controllers.DepartmentAlreadyExistsException;
import ch.etml.es.payroll.entities.Department;
import ch.etml.es.payroll.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private static DepartmentRepository repository = null;
    private static EmployeeServiceProperties props = null;

    public DepartmentService(DepartmentRepository repository, EmployeeServiceProperties props) {
        DepartmentService.repository = repository;
        DepartmentService.props = props;
    }

    public static Department create(Department department) {
        Department existing = repository.findByAcronym(department.getAcronym())
                .orElse(null);

        if (existing != null) {
            throw new DepartmentAlreadyExistsException(department.getAcronym());
        }
        return repository.save(department);
    }


    public Department hireEmployee(long l, Long employeeId) {
        return null;
    }
}
