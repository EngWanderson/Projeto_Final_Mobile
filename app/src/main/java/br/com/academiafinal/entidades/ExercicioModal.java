package br.com.academiafinal.entidades;

public class ExercicioModal {
    String nomeExercicio;

    int image;


    public ExercicioModal(String nomeExercicio, int image) {
        this.nomeExercicio = nomeExercicio;
        this.image = image;
    }

    public String getNomeExercicio() {
        return nomeExercicio;
    }

    public int getImage() {
        return image;
    }
}
