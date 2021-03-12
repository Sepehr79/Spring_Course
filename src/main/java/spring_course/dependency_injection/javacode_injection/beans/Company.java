package spring_course.dependency_injection.javacode_injection.beans;

public class Company {

    private String companyName;
    private String companyNation;

    public Company(String companyName, String companyNation) {
        this.companyName = companyName;
        this.companyNation = companyNation;
    }

    public Company() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyNation() {
        return companyNation;
    }

    public void setCompanyNation(String companyNation) {
        this.companyNation = companyNation;
    }
}
