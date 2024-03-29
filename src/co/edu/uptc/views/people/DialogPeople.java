package co.edu.uptc.views.people;

import co.edu.uptc.pojos.Person;
import co.edu.uptc.views.dashBoard.DashBoard;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class DialogPeople extends JDialog {
    private DashBoard dashBoard;

    private PanelButtom panelButtom;
    private PanelModelSelect panelModelSelect;

    private PanelInput panelInput;

    private int height = 800;
    public DialogPeople(DashBoard dashBoard)  {
        super(dashBoard,true);
        this.dashBoard = dashBoard;
        setSize(new Dimension(700 ,height));
        setLocationRelativeTo(dashBoard);
        addComponents();
    }

    private void addComponents(){
        panelInput = new PanelInput(this);
        add(panelInput,BorderLayout.CENTER);
        panelButtom = new PanelButtom(this);
        add(panelButtom, BorderLayout.SOUTH);
        addPanelModelSelect();
    }

    private void addPanelModelSelect(){
        panelModelSelect = new PanelModelSelect(this);
        JScrollPane scrollPane = new JScrollPane(panelModelSelect);
        add(scrollPane,BorderLayout.EAST);
    }


    public void close(){
        this.setVisible(false);
        this.dispose();
    }

    public Person getPerson(String attribute){
       return dashBoard.getPerson(attribute);
    }

    public Person getSelectedPerson(){
        return panelInput.getSelectedPerson();
    }

    public String getAuthorOfModel(){
        return dashBoard.getAuthorModel();
    }

    public void showMessageError(String value){
        dashBoard.notifyError(value);
    }

    public void showMessageWarning(String value){
        dashBoard.notifyWarning(value);
    }
    public void updateAuthorModel(){
        panelInput.updateAuthorModel();
    }

    public void editPerson(Person person){
        dashBoard.editPerson(person);
    }
    public Person getPerson(){
        Person person = new Person();
        person.setCode(panelInput.textFieldCode.getText());
        person.setName(panelInput.textFieldName.getText());
        return  person;
    }

    public void addPerson(){
        Person p = getPerson();
        dashBoard.addPerson(p);
    }

    public void updatedPerson(){
        panelInput.loadPeople();
    }

    public List<Person> getPeople(){
        return dashBoard.getPeople();
    }

}
