import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainPanel extends JPanel {
    private ArrayList<Passenger> passengers;
    private int fileCounter;
    private int statsFileCounter;

    private JComboBox<String> survivedComboBox;
    private JTextField minPassengerIdField;
    private JTextField maxPassengerIdField;
    private JTextField passengerNameField;
    private JComboBox<String> passengerSexBox;
    private JTextField sibSpField;
    private JTextField parchField;
    private JTextField ticketNumberField;
    private JTextField minFareField;
    private JTextField maxFareField;
    private JTextField cabinNumberField;
    private JComboBox<String> embarkedBox;

    public MainPanel (int x, int y, int width, int height) {
        File file = new File(Constants.PATH_TO_DATA_FILE); //this is the path to the data file
        passengers = new ArrayList<>();
        fileCounter = 1;
        statsFileCounter = 1;
        readFile(file);
        this.setLayout(null);
        this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);

        JLabel survivedLabel = new JLabel("Passenger Class: ");
        survivedLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(survivedLabel);
        this.survivedComboBox = new JComboBox<>(Constants.PASSENGER_CLASS_OPTIONS);
        this.survivedComboBox.setBounds(survivedLabel.getX() + survivedLabel.getWidth() + 1, survivedLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.survivedComboBox);
        this.survivedComboBox.addActionListener((e) -> {
            //do whatever you want on change
        });
        JLabel survivedLabel2 = new JLabel("min passenger id: ");
        survivedLabel2.setBounds(x + Constants.MARGIN_FROM_LEFT, y+Constants.LABEL_HEIGHT, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(survivedLabel2);
        this.minPassengerIdField = new JTextField();
        minPassengerIdField.setBounds(x+Constants.MARGIN_FROM_LEFT+Constants.LABEL_WIDTH,y+Constants.LABEL_HEIGHT, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(minPassengerIdField);

        JLabel survivedLabel3 = new JLabel("max passenger id: ");
        survivedLabel3.setBounds(x + Constants.MARGIN_FROM_LEFT, y+2*Constants.LABEL_HEIGHT, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(survivedLabel3);
        this.maxPassengerIdField = new JTextField();
        maxPassengerIdField.setBounds(x+Constants.MARGIN_FROM_LEFT+Constants.LABEL_WIDTH,y+2*Constants.LABEL_HEIGHT, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(maxPassengerIdField);

        JLabel survivedLabel4 = new JLabel("passenger name: ");
        survivedLabel4.setBounds(x + Constants.MARGIN_FROM_LEFT, y+3*Constants.LABEL_HEIGHT, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(survivedLabel4);
        this.passengerNameField = new JTextField();
        passengerNameField.setBounds(x+Constants.MARGIN_FROM_LEFT+Constants.LABEL_WIDTH,y+3*Constants.LABEL_HEIGHT, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(passengerNameField);

        JLabel survivedLabel5 = new JLabel("passenger sex: ");
        survivedLabel5.setBounds(x + Constants.MARGIN_FROM_LEFT, y+4*Constants.LABEL_HEIGHT, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(survivedLabel5);
        this.passengerSexBox = new JComboBox<>(Constants.PASSENGER_SEX_OPTIONS);
        passengerSexBox.setBounds(x + Constants.MARGIN_FROM_LEFT+Constants.LABEL_WIDTH, y+4*Constants.LABEL_HEIGHT, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(passengerSexBox);

        JLabel survivedLabel6 = new JLabel("sibSp: ");
        survivedLabel6.setBounds(x + Constants.MARGIN_FROM_LEFT, y+5*Constants.LABEL_HEIGHT, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(survivedLabel6);
        this.sibSpField = new JTextField();
        sibSpField.setBounds(x + Constants.MARGIN_FROM_LEFT+Constants.LABEL_WIDTH, y+5*Constants.LABEL_HEIGHT, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(sibSpField);

        JLabel survivedLabel7 = new JLabel("parch: ");
        survivedLabel7.setBounds(x + Constants.MARGIN_FROM_LEFT, y+6*Constants.LABEL_HEIGHT, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(survivedLabel7);
        this.parchField = new JTextField();
        parchField.setBounds(x + Constants.MARGIN_FROM_LEFT+Constants.LABEL_WIDTH, y+6*Constants.LABEL_HEIGHT, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(parchField);

        JLabel survivedLabel8 = new JLabel("ticket number: ");
        survivedLabel8.setBounds(x + Constants.MARGIN_FROM_LEFT, y+7*Constants.LABEL_HEIGHT, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(survivedLabel8);
        this.ticketNumberField = new JTextField();
        ticketNumberField.setBounds(x + Constants.MARGIN_FROM_LEFT+Constants.LABEL_WIDTH, y+7*Constants.LABEL_HEIGHT, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(ticketNumberField);

        JLabel survivedLabel9 = new JLabel("min fare: ");
        survivedLabel9.setBounds(x + Constants.MARGIN_FROM_LEFT, y+8*Constants.LABEL_HEIGHT, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(survivedLabel9);
        this.minFareField = new JTextField();
        minFareField.setBounds(x + Constants.MARGIN_FROM_LEFT+Constants.LABEL_WIDTH, y+8*Constants.LABEL_HEIGHT, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(minFareField);

        JLabel survivedLabel10 = new JLabel("max fare: ");
        survivedLabel10.setBounds(x + Constants.MARGIN_FROM_LEFT, y+9*Constants.LABEL_HEIGHT, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(survivedLabel10);
        this.maxFareField = new JTextField();
        maxFareField.setBounds(x + Constants.MARGIN_FROM_LEFT+Constants.LABEL_WIDTH, y+9*Constants.LABEL_HEIGHT, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(maxFareField);

        JLabel survivedLabel11 = new JLabel("cabin number: ");
        survivedLabel11.setBounds(x + Constants.MARGIN_FROM_LEFT, y+10*Constants.LABEL_HEIGHT, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(survivedLabel11);
        this.cabinNumberField = new JTextField();
        cabinNumberField.setBounds(x + Constants.MARGIN_FROM_LEFT+Constants.LABEL_WIDTH, y+10*Constants.LABEL_HEIGHT, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(cabinNumberField);

        JLabel survivedLabel12 = new JLabel("embarked: ");
        survivedLabel12.setBounds(x + Constants.MARGIN_FROM_LEFT, y+11*Constants.LABEL_HEIGHT, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(survivedLabel12);
        this.embarkedBox = new JComboBox<>(Constants.PASSENGER_EMBARKED_OPTIONS);
        embarkedBox.setBounds(x + Constants.MARGIN_FROM_LEFT+Constants.LABEL_WIDTH, y+11*Constants.LABEL_HEIGHT, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(embarkedBox);

        JLabel result = new JLabel();
        result.setBounds(width/2-20,height/2-120+Constants.BUTTON_SIZE, Constants.LABEL_WIDTH_WIDE,Constants.LABEL_HEIGHT);
        this.add(result);

        JButton start = new JButton("start");
        start.setBounds(width/2-20,height/2-120, Constants.BUTTON_SIZE, Constants.BUTTON_SIZE);
        start.addActionListener(event -> {
            List<Passenger> filter = filter();
            long survived = filter.stream().filter(passenger -> passenger.isSurvived()).count();
            result.setText("Total rows: "+filter.size()+" ("+survived+" survived, "+ (filter.size()-survived)+" did not)");
            repaint();
            writeCSVFile(filter,fileCounter);
            fileCounter++;
        });
        this.add(start);

        JButton statsButton = new JButton("make stats file");
        statsButton.setBounds(start.getX(),start.getY()-Constants.BUTTON_SIZE,Constants.BUTTON_SIZE,Constants.BUTTON_SIZE);
        statsButton.addActionListener(event -> {
            List<Passenger> filter = filter();
            try {
                writeStatsFile(filter);
                statsFileCounter++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        this.add(statsButton);


    }

    public void writeStatsFile(List<Passenger> passengers) throws Exception {
        File statsFile = new File("src/main/resources/statistics" + statsFileCounter + ".txt");
        FileWriter writer = new FileWriter(statsFile);
        int[] iteration = {1};
        for (int i = 1; i <= 3; i++) {
            iteration[0] = i;
            int classesPeople = (int) passengers.stream().filter(passenger -> passenger.getpClass()==iteration[0]).count();
            int classesSurvivors = (int) passengers.stream().filter(passenger -> passenger.getpClass() == iteration[0]).filter(Passenger::isSurvived).count();
            double classSurvivorsPercents = ((double) classesSurvivors / classesPeople) * 100;
            writer.write("survivor percent in "+i+" class is: " +classSurvivorsPercents);
            writer.write("\n");
        }
        int malePeople = (int) passengers.stream().filter(passenger -> passenger.getSex().equals("male")).count();
        int maleSurvivors = (int) passengers.stream().filter(passenger -> passenger.getSex().equals("male")).filter(Passenger::isSurvived).count();
        double maleSurvivorPercents = ((double) maleSurvivors / malePeople)*100;
        int femalePeople = (int) passengers.stream().filter(passenger -> passenger.getSex().equals("female")).count();
        int femaleSurvivors = (int) passengers.stream().filter(passenger -> passenger.getSex().equals("female")).filter(Passenger::isSurvived).count();
        double femaleSurvivorPercents = ((double) femaleSurvivors / femalePeople)*100;
        writer.write("male survivor percent is: "+maleSurvivorPercents+"\n");
        writer.write("female survivor percent is: "+femaleSurvivorPercents+"\n");

        for (int i=1; i<=5; i++) {
            iteration[0] = i;
            int age = iteration[0]*10;
            int people = (int) passengers.stream().filter(passenger -> passenger.getAge()>age-10).filter(passenger -> passenger.getAge()<=age).count();
            int survivors = (int) passengers.stream().filter(passenger -> passenger.getAge()>age-10).filter(passenger -> passenger.getAge()<=age).filter(Passenger::isSurvived).count();
            double survivorsPercents = ((double) survivors/people)*100;
            writer.write("survivors percent between "+(age-9)+" to "+age+" is: "+survivorsPercents);
            writer.write("\n");
        }
        int oldPeople = (int) passengers.stream().filter(passenger -> passenger.getAge()>50).count();
        int oldSurvivors = (int) passengers.stream().filter(passenger -> passenger.getAge()>50).filter(Passenger::isSurvived).count();
        double oldSurvivorPercent = ((double) oldSurvivors/ oldPeople) *100;
        writer.write("survivors percent over 50 is: "+oldSurvivorPercent+"\n");

        int peopleWithFamily = (int) passengers.stream().filter(passenger -> passenger.getParch()+passenger.getSibSp()>0).count();
        int survivorsWithFamily = (int) passengers.stream().filter(passenger -> passenger.getParch()+passenger.getSibSp()>0).filter(Passenger::isSurvived).count();
        double survivorWithFamilyPercent = ((double) survivorsWithFamily/peopleWithFamily)*100;
        writer.write("survivors with family percent: "+survivorWithFamilyPercent+"\n");

        int peopleWithoutFamily = (int) passengers.stream().filter(passenger -> passenger.getParch()+passenger.getSibSp()==0).count();
        int survivorsWithoutFamily = (int) passengers.stream().filter(passenger -> passenger.getParch()+passenger.getSibSp()==0).filter(Passenger::isSurvived).count();
        double survivorWithoutFamilyPercent = ((double) survivorsWithoutFamily/peopleWithoutFamily)*100;
        writer.write("survivors without family percent: "+survivorWithoutFamilyPercent+"\n");

        int peopleUnder10 = (int) passengers.stream().filter(passenger -> passenger.getFare()<10).count();
        int survivorsUnder10 = (int) passengers.stream().filter(passenger -> passenger.getFare()<10).filter(Passenger::isSurvived).count();
        double survivorsUnder10Percent= ((double) survivorsUnder10/peopleUnder10)*100;
        writer.write("survivors who paid under 10 bucks percent: "+survivorsUnder10Percent+"\n");

        int peopleOver10 = (int) passengers.stream().filter(passenger -> passenger.getFare()>=10 && passenger.getFare()<30).count();
        int survivorsOver10 = (int) passengers.stream().filter(passenger -> passenger.getFare()>=10 && passenger.getFare()<30).filter(Passenger::isSurvived).count();
        double survivorsOver10Percent= ((double) survivorsOver10/peopleOver10)*100;
        writer.write("survivors who paid 10-30 bucks percent: "+survivorsOver10Percent+"\n");

        int peopleOver30 = (int) passengers.stream().filter(passenger -> passenger.getFare()>30).count();
        int survivorsOver30 = (int) passengers.stream().filter(passenger -> passenger.getFare()>30).filter(Passenger::isSurvived).count();
        double survivorsOver30Percent= ((double) survivorsOver30/peopleOver30)*100;
        writer.write("survivors who paid over 30 bucks percent: "+survivorsOver30Percent+"\n");

        int embarkedS = (int) passengers.stream().filter(passenger -> passenger.getEmbarked().equals("S")).count();
        int embarkedSSurvivors = (int) passengers.stream().filter(passenger -> passenger.getEmbarked().equals("S")).filter(Passenger::isSurvived).count();
        double sSurvivors = ((double) embarkedSSurvivors/embarkedS)*100;
        writer.write("Embarked S survivors percent: "+sSurvivors+"\n");

        int embarkedC = (int) passengers.stream().filter(passenger -> passenger.getEmbarked().equals("C")).count();
        int embarkedCSurvivors = (int) passengers.stream().filter(passenger -> passenger.getEmbarked().equals("C")).filter(Passenger::isSurvived).count();
        double cSurvivors = ((double) embarkedCSurvivors/embarkedC)*100;
        writer.write("Embarked C survivors percent: "+cSurvivors+"\n");

        int embarkedQ = (int) passengers.stream().filter(passenger -> passenger.getEmbarked().equals("Q")).count();
        int embarkedQSurvivors = (int) passengers.stream().filter(passenger -> passenger.getEmbarked().equals("Q")).filter(Passenger::isSurvived).count();
        double qSurvivors = ((double) embarkedQSurvivors/embarkedQ)*100;
        writer.write("Embarked S survivors percent: "+qSurvivors+"\n");

        writer.close();
    }


    public List<Passenger> filter () {
        List<Passenger> filter = passengers.stream().collect(Collectors.toList());
        if (!survivedComboBox.getSelectedItem().equals("All")) {
            String selected = (String) survivedComboBox.getSelectedItem();
            filter = filter.stream()
                    .filter(passenger -> passenger.getpClass()==Integer.parseInt(selected.substring(0,1)))
                    .collect(Collectors.toList());
        }
        if (!minPassengerIdField.getText().equals("")) {
            int selected = Integer.parseInt(minPassengerIdField.getText());
            filter = filter.stream()
                    .filter(passenger -> passenger.getId()>=selected)
                    .collect(Collectors.toList());
        }
        if (!maxPassengerIdField.getText().equals("")) {
            int selected = Integer.parseInt(maxPassengerIdField.getText());
            filter = filter.stream()
                    .filter(passenger -> passenger.getId()<=selected)
                    .collect(Collectors.toList());
        }
        if (!passengerNameField.getText().equals("")) {
            String selected = passengerNameField.getText();
            filter = filter.stream()
                    .filter(passenger -> passenger.getFormattedName().equals(selected))
                    .collect(Collectors.toList());
        }
        if (!passengerSexBox.getSelectedItem().equals("All")) {
            String selected = (String) passengerSexBox.getSelectedItem();
            filter = filter.stream()
                    .filter(passenger -> passenger.getSex().equals(selected))
                    .collect(Collectors.toList());
        }
        if (!sibSpField.getText().equals("")) {
            int selected = Integer.parseInt(sibSpField.getText());
            filter = filter.stream()
                    .filter(passenger -> passenger.getSibSp()==selected)
                    .collect(Collectors.toList());
        }
        if (!parchField.getText().equals("")) {
            int selected = Integer.parseInt(parchField.getText());
            filter = filter.stream()
                    .filter(passenger -> passenger.getParch()==selected)
                    .collect(Collectors.toList());
        }
        if (!ticketNumberField.getText().equals("")) {
            String selected = ticketNumberField.getText();
            filter = filter.stream()
                    .filter(passenger -> passenger.getTicket().equals(selected))
                    .collect(Collectors.toList());
        }
        if (!minFareField.getText().equals("")) {
            double selected = Double.parseDouble(minFareField.getText());
            filter = filter.stream()
                    .filter(passenger -> passenger.getFare()>=selected)
                    .collect(Collectors.toList());
        }
        if (!maxFareField.getText().equals("")) {
            double selected = Double.parseDouble(maxFareField.getText());
            filter = filter.stream()
                    .filter(passenger -> passenger.getFare()<=selected)
                    .collect(Collectors.toList());
        }
        if (!cabinNumberField.getText().equals("")) {
            String selected = cabinNumberField.getText();
            filter = filter.stream()
                    .filter(passenger -> passenger.getCabin().equals(selected))
                    .collect(Collectors.toList());
        }
        if (!embarkedBox.getSelectedItem().equals("All")) {
            String selected = (String) embarkedBox.getSelectedItem();
            filter = filter.stream()
                    .filter(passenger -> passenger.getEmbarked().equals(selected))
                    .collect(Collectors.toList());
        }

        return filter;

    }

    public static void writeCSVFile(List<Passenger> passengers, int fileCounter) {
        String path = "C:\\Users\\Yotam\\documents\\"+fileCounter+".csv";
        File file = new File(path);
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("PassengerId,Survived,Pclass,Name,Sex,Age,SibSp,Parch,Ticket,Fare,Cabin,Embarked");
            fileWriter.write("\n");
            int count = 1;
            for (Passenger passenger: passengers) {
                fileWriter.write(count+","+(passenger.isSurvived()? "1,": "0,") + passenger.getpClass()+"," +passenger.getFormattedName()+","+passenger.getSex()+","+ passenger.getAge()+","+passenger.getSibSp()+","+
                        passenger.getParch()+","+passenger.getTicket()+","+passenger.getFare()+","+passenger.getCabin()+","+passenger.getEmbarked());
                fileWriter.write("\n");
                count++;
            }
            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void readFile(File file) {
        try {
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            while(scanner.hasNextLine()) {
                String row = scanner.nextLine();
                String[] split = row.split(",");
                Passenger passenger = new Passenger();
                passenger.setId(Integer.parseInt(split[0]));
                passenger.setSurvived(!split[1].equals("0"));
                passenger.setpClass(Integer.parseInt(split[2]));
                passenger.setName(split[3].substring(1)+ ","+ split[4].substring(0,split[4].length()-1));
                passenger.setSex(split[5]);
                passenger.setAge((!split[6].equals("") ? Double.parseDouble(split[6]) : 0));
                passenger.setSibSp(Integer.parseInt(split[7]));
                passenger.setParch(Integer.parseInt(split[8]));
                passenger.setTicket(split[9]);
                passenger.setFare(Double.parseDouble(split[10]));
                passenger.setCabin(split[11]);
                passenger.setEmbarked(split.length>12 ? split[12]: "");

                passengers.add(passenger);

            }
        } catch (Exception e) {

        }
    }



}
