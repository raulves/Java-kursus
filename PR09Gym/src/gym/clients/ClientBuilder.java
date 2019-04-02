package gym.clients;

public class ClientBuilder {
    private String name;
    private Double membershipFee;
    private Integer age;
    private Boolean hasDiscount;
    private ClientBuilder partner;

    public ClientBuilder(String name) {
        this.name = name;
        this.membershipFee = 0.0;

    }

    public ClientBuilder setAge(Integer age) {
        this.age = age;
        return this;
    }

    public ClientBuilder setHasDiscount(Boolean hasDiscount) {
        this.hasDiscount = hasDiscount;
        return this;
    }

    public ClientBuilder setTrainingPartner(ClientBuilder trainingPartner) {
        // trainingPartner.setPartner(this);
        this.partner = trainingPartner;

        return this;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getmembershipFee() {
        return membershipFee;
    }

    public void setMembershipFee(Double membershipFee) {
        this.membershipFee = membershipFee;
    }

    public Integer getAge() {
        return age;
    }

    public Boolean getHasDiscount() {
        return hasDiscount;
    }

    public ClientBuilder getPartner() {
        return partner;
    }

    public void setPartner(ClientBuilder partner) {
        this.partner = partner;
    }

    @Override
    public String toString() {
        return "Client name: " + name +
                ". Membership fee: " + membershipFee +
                ". Training partner: " + partner;
    }
}
