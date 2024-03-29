package co.edu.uptc.models.Model202114641;

import co.edu.uptc.pojos.Person;

import java.util.ArrayList;
import java.util.List;

public class ManagerPersonSebastian {
     private ArbolUPTC arbolUPTC;
     private ManagerModelSebastian managerModel;
     List<Person> listPeople;
    public ManagerPersonSebastian(ManagerModelSebastian managerModel) {
        this.managerModel = managerModel;
        arbolUPTC= new ArbolUPTC();
    }
    public void addPerson(Person person){
        if (person.getName().equals("") || person.getCode().equals("")) {
            managerModel.presenter.notifyError("Información incompleta");
        } else {
            arbolUPTC.agregar(person);
            managerModel.presenter.notifyPeopleUpdated();
        }
    }

    public Person getPerson(String attribute){
    listPeople= arbolUPTC.getList();
        for (Person per: listPeople) {
            if(attribute.equals(per.getCode()) || attribute.equals(per.getName())){
                return per;
            }
        }


        return null;


    }


    public void editPerson(Person person){
       listPeople= arbolUPTC.getList();
        for (Person per: listPeople) {
            if(per.getId()==person.getId()){
                per.setCode(person.getCode());
                per.setName(person.getName());
                return;
            }
        }


    }

    public List<Person> getPeople() {
        listPeople= arbolUPTC.getList();

        return listPeople;

    }
}
