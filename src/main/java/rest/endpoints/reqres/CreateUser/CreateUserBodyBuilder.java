package rest.endpoints.reqres.CreateUser;

public class CreateUserBodyBuilder {
    CreateUserBody createUserBody;

    public CreateUserBodyBuilder() {
        this.createUserBody = new CreateUserBody();
    }

    public CreateUserBodyBuilder withName(String name) {
        createUserBody.setName(name);
        return this;
    }

    public CreateUserBodyBuilder withJob(String job) {
        createUserBody.setJob(job);
        return this;
    }

    public CreateUserBody build() {
        return createUserBody;
    }
}
