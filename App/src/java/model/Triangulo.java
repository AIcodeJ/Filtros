/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Alexis
 */
public class Triangulo {
 
    private double Base;
    private double Height;
    private double Result;
    private double Resulta;
    private String usuario;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Triangulo(String B, String H) {
        this.setBase(Double.parseDouble(B));
        this.setHeight(Double.parseDouble(H));
    }
    
    public void Area(){
        double a = (this.getBase() * this.getHeight()) / 2;
        this.setResult(a);
    }
    
    public void Perimeter(){
        double p = this.getBase() * 3;
        this.setResulta(p);
    }

    public double getHeight() {
        return Height;
    }

    public void setHeight(double Height) {
        this.Height = Height;
    }

    public double getBase() {
        return Base;
    }

    public void setBase(double Base) {
        this.Base = Base;
    }
    
    public double getResult() {
        return Result;
    }

    public void setResult(double Result) {
        this.Result = Result;
    }

    public double getResulta() {
        return Resulta;
    }

    public void setResulta(double Resulta) {
        this.Resulta = Resulta;
    }
    
}
