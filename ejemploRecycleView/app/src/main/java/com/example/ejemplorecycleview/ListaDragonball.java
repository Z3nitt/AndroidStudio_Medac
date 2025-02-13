package com.example.ejemplorecycleview;

import java.util.ArrayList;

public class ListaDragonball {
    private ArrayList<Personaje> listaDragonBall = new ArrayList<>();

    public ListaDragonball() {
        listaDragonBall.add(new Personaje("Goku", "Guerrero saiyajin valiente.", "Goku es el protagonista de la serie, conocido por su espíritu indomable y su búsqueda constante de superación. A lo largo de su vida, ha defendido la Tierra de poderosos enemigos y ha alcanzado numerosas transformaciones, incluyendo Super Saiyajin.", R.drawable.goku));
        listaDragonBall.add(new Personaje("Vegeta", "Príncipe saiyajin orgulloso.", "Inicialmente un villano, Vegeta se une a Goku en la lucha contra enemigos comunes. Su orgullo y deseo de superar a Goku lo llevan a entrenar arduamente, logrando también poderosas transformaciones.", R.drawable.vegeta));
        listaDragonBall.add(new Personaje("Gohan", "Hijo mayor de Goku.", "A pesar de su naturaleza amable, Gohan se convierte en un formidable luchador en momentos de crisis. Su transformación en Super Saiyajin 2 durante la pelea contra Cell es uno de los momentos más memorables de la serie.", R.drawable.gohan));
        listaDragonBall.add(new Personaje("Piccolo", "Guerrero Namekiano sabio.", "Piccolo, originalmente un enemigo de Goku, se convierte en un importante defensor de la Tierra. Su inteligencia y técnicas de combate son fundamentales en muchas batallas, y su relación con Gohan es especialmente profunda.", R.drawable.piccolo));
        listaDragonBall.add(new Personaje("Majin Buu", "Ser mágico destructivo.", "Buu tiene varias formas, cada una con diferentes personalidades y habilidades. Su naturaleza puede ser tanto malvada como inocente, lo que lo convierte en un personaje complejo en la historia.", R.drawable.buu));
        listaDragonBall.add(new Personaje("Cell", "Bio-androide en busca de perfección.", "Cell es uno de los antagonistas más temidos de la serie, capaz de transformarse en varias formas más poderosas. Su torneo de lucha contra Gohan es un clímax memorable en la saga.", R.drawable.cell));
        listaDragonBall.add(new Personaje("Freezer", "Tirano intergaláctico cruel.", "Freezer es uno de los villanos más icónicos de la serie, responsable de la destrucción del planeta Vegeta. Su lucha contra Goku en el planeta Namek es una de las batallas más épicas de la saga.", R.drawable.freezer));
        listaDragonBall.add(new Personaje("Broly", "Guerrero saiyajin legendario.", "Broly es conocido como el 'Super Saiyajin Legendario'. Su historia trágica y su inmenso poder lo convierten en un adversario temido y respetado en el universo de Dragon Ball.", R.drawable.broly));
        listaDragonBall.add(new Personaje("Gogeta", "Fusión poderosa entre Goku y Vegeta.", "Con habilidades que combinan las técnicas de ambos guerreros, Gogeta es un combatiente formidable, capaz de derrotar a los enemigos más poderosos en cuestión de minutos.", R.drawable.gogeta));
        listaDragonBall.add(new Personaje("Vegito", "Fusión astuta de Goku y Vegeta.", "La fusión de Goku y Vegeta a través de los pendientes Potara le da a Vegito habilidades únicas y un carácter burlón. Su batalla contra Majin Buu es uno de los momentos destacados de la serie.", R.drawable.vegito));
        listaDragonBall.add(new Personaje("Goku", "Guerrero saiyajin valiente.", "Goku es el protagonista de la serie, conocido por su espíritu indomable y su búsqueda constante de superación. A lo largo de su vida, ha defendido la Tierra de poderosos enemigos y ha alcanzado numerosas transformaciones, incluyendo Super Saiyajin.", R.drawable.goku));
        listaDragonBall.add(new Personaje("Vegeta", "Príncipe saiyajin orgulloso.", "Inicialmente un villano, Vegeta se une a Goku en la lucha contra enemigos comunes. Su orgullo y deseo de superar a Goku lo llevan a entrenar arduamente, logrando también poderosas transformaciones.", R.drawable.vegeta));
        listaDragonBall.add(new Personaje("Gohan", "Hijo mayor de Goku.", "A pesar de su naturaleza amable, Gohan se convierte en un formidable luchador en momentos de crisis. Su transformación en Super Saiyajin 2 durante la pelea contra Cell es uno de los momentos más memorables de la serie.", R.drawable.gohan));
        listaDragonBall.add(new Personaje("Piccolo", "Guerrero Namekiano sabio.", "Piccolo, originalmente un enemigo de Goku, se convierte en un importante defensor de la Tierra. Su inteligencia y técnicas de combate son fundamentales en muchas batallas, y su relación con Gohan es especialmente profunda.", R.drawable.piccolo));
        listaDragonBall.add(new Personaje("Majin Buu", "Ser mágico destructivo.", "Buu tiene varias formas, cada una con diferentes personalidades y habilidades. Su naturaleza puede ser tanto malvada como inocente, lo que lo convierte en un personaje complejo en la historia.", R.drawable.buu));
        listaDragonBall.add(new Personaje("Cell", "Bio-androide en busca de perfección.", "Cell es uno de los antagonistas más temidos de la serie, capaz de transformarse en varias formas más poderosas. Su torneo de lucha contra Gohan es un clímax memorable en la saga.", R.drawable.cell));
        listaDragonBall.add(new Personaje("Freezer", "Tirano intergaláctico cruel.", "Freezer es uno de los villanos más icónicos de la serie, responsable de la destrucción del planeta Vegeta. Su lucha contra Goku en el planeta Namek es una de las batallas más épicas de la saga.", R.drawable.freezer));
        listaDragonBall.add(new Personaje("Broly", "Guerrero saiyajin legendario.", "Broly es conocido como el 'Super Saiyajin Legendario'. Su historia trágica y su inmenso poder lo convierten en un adversario temido y respetado en el universo de Dragon Ball.", R.drawable.broly));
        listaDragonBall.add(new Personaje("Gogeta", "Fusión poderosa entre Goku y Vegeta.", "Con habilidades que combinan las técnicas de ambos guerreros, Gogeta es un combatiente formidable, capaz de derrotar a los enemigos más poderosos en cuestión de minutos.", R.drawable.gogeta));
        listaDragonBall.add(new Personaje("Vegito", "Fusión astuta de Goku y Vegeta.", "La fusión de Goku y Vegeta a través de los pendientes Potara le da a Vegito habilidades únicas y un carácter burlón. Su batalla contra Majin Buu es uno de los momentos destacados de la serie.", R.drawable.vegito));
    }

    public ArrayList<Personaje> getListaDragonBall() {
        return listaDragonBall;
    }

    public void setListaDragonBall(ArrayList<Personaje> listaDragonBall) {
        this.listaDragonBall = listaDragonBall;
    }
}
