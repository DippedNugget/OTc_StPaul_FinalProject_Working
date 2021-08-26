package OTC.StPaul.Final.Project.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import OTC.StPaul.Final.Project.entity.Individual_Roles;
import OTC.StPaul.Final.Project.entity.user_roles;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/otc_stpaul_blockbuster")
@OpenAPIDefinition(info = @Info(title = "OTC StPaul Blockbuster"), servers = {
    @Server(url = "http://localhost:8080", description = "Local Server.")})
public interface UserRolesController {
  
  @GetMapping("/alluser_roles/{emp_username}")
  @ResponseStatus(code = HttpStatus.OK)
  ResponseEntity<List<user_roles>> getUserRoles(
      @PathVariable String emp_username);

  @GetMapping("/user_roles/{roles}")
  @ResponseStatus(code = HttpStatus.OK)
  ResponseEntity<List<user_roles>> retrieveAllEmployeesOfACertainRole(
      @RequestParam(required = true) Individual_Roles role);
  
  @PostMapping("/adduser_roles/{emp_username}")
  @ResponseStatus(code = HttpStatus.CREATED)
  void addRolesForEmployees(
      @RequestParam(required = true) String emp_username,
      @RequestParam(required = true) String user_role);
  
  @DeleteMapping("/deleteuser_roles/{role_id}")
  @ResponseStatus(code = HttpStatus.OK)
  void deleteRolesFromEmployeeByRoleId(
      @PathVariable Long role_id);
  
} // last bracket
