# Reimbursement Project
This project is a management system that allows employees to create reimbursement requests. Managers can then login and accept or deny the request. Each request must have a reason and an amount requested. 

## Technologies Used

Servlets- 5.0v

Tomcat- 8.5.77v

Hibernate- 5.6.0v

## Features
Employees can 
- Login
- Create a reimbursement request
- Edit their user information
- Review their request history

Managers can
- Login
- Access unique manager features
- Review all pending requests
- Review all resolved requests
- Approve/Deny requests
- Review requests from a specific employee
- View a list of all employees
- Create a new employee account 

To/Do List
- Fix supporting document insertion as to allow employees to supply receipts as proof of purchase

## Getting Started

1.) clone the git repository to your desired file location

~~~

git clone https://github.com/cgonzalez233/ReimbursementProject.git

~~~

2.) edit the hibernate.cfg.xml file to fit your environment

~~~

<property  name="connection.driver_class">com.mysql.cj.jdbc.Driver</property>

<property  name="connection.url">jdbc:mysql://localhost:3306/**project database**</property>

<property  name="connection.username">**SQL Username**</property>

<property  name="connection.password">**SQL Password**</property>

<property  name="dialect">org.hibernate.dialect.MySQL5Dialect</property>

<property  name="hbm2ddl.auto">update</property>

<property  name="show_sql">true</property>

<mapping  class="Employee"/>

<mapping  class="Reimbursement"/>

~~~

3.) If not already done add tomcat to your configurations

4.) run the application

## Contributors

Christian Gonzalez

Shawn Boutte
