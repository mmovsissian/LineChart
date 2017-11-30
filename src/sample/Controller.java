package sample;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.Button;

import java.awt.*;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;

public class Controller {

    @FXML
  private   Button load;

    @FXML
   private Button sum;

    @FXML
    private  Button print;

    @FXML
    private  Button max;

    @FXML
    private  Button sort;

    @FXML
    private LineChart<String, Number> linechart;

    int summ;
    int maxvalue=0;

    public void initialize(){
        XYChart.Series<String, Number> numberchart= new XYChart.Series<>();
        numberchart.getData().add(new XYChart.Data<>("Bob", 1500));
        numberchart.getData().add(new XYChart.Data<>("John", 3000));
        numberchart.getData().add(new XYChart.Data<>("Mike", 2000));
        numberchart.getData().add(new XYChart.Data<>("Sam", 5000));
        load.setOnAction(event -> {
            linechart.getData().add(numberchart);
            numberchart.setName("Salaries");



        });



        for (XYChart.Data<String,Number>data: numberchart.getData()){
            summ+=data.getYValue().intValue();
            if (data.getYValue().intValue()>=maxvalue){maxvalue=data.getYValue().intValue();}

        }
        sum.setOnAction(event ->
            System.out.println(summ));

        max.setOnAction(event ->
                System.out.println(maxvalue));

        print.setOnAction(event -> {
            for (XYChart.Data<String,Number>data: numberchart.getData()){
                System.out.println(data.getXValue()+data.getYValue().intValue());
        }});

        sort.setOnAction(event -> {

            linechart.getData().removeAll();


            XYChart.Series<String, Number> numberchartsorted= new XYChart.Series<>();

            numberchartsorted.getData().add(new XYChart.Data<>("Bob", 1500));
            numberchartsorted.getData().add(new XYChart.Data<>("John", 3000));
            numberchartsorted.getData().add(new XYChart.Data<>("Mike", 2000));
            numberchartsorted.getData().add(new XYChart.Data<>("Sam", 5000));

            Collections.sort(numberchartsorted.getData(), new Comparator<XYChart.Data<String, Number>>() {
                @Override
                public int compare(XYChart.Data<String, Number> o1, XYChart.Data<String, Number> o2) {
                    return new BigDecimal(o1.getYValue().toString()).compareTo(new BigDecimal(o2.getYValue().toString()))
                            ;
                }
            });
            linechart.getData().add(numberchartsorted);

        });

    }

}



