public class ListeDoublementChainee {

    static class Noeud {
        int val;
        Noeud prec;
        Noeud suiv;

        Noeud(int val) {
            this.val = val;
        }
    }

    Noeud tete;

    Noeud queue;



    public void ajouter(int val) {
        Noeud n = new Noeud(val);
        if (tete == null) {
            tete = n;
            queue = n;
        } else {
            queue.suiv = n;
            n.prec = queue;
            queue = n;
        }
    }

    public void triBulles() {
        if (tete == null || tete.suiv == null) {
            return;
        }
        boolean echange;
        Noeud fin = queue;
        do {
            echange = false;
            Noeud courant = tete;
            while (courant != fin) {
                if (courant.val > courant.suiv.val) {
                    int tmp = courant.val;
                    courant.val = courant.suiv.val;
                    courant.suiv.val = tmp;
                    echange = true;
                }
                courant = courant.suiv;
            }
            fin = fin.prec;
        } while (echange && fin != tete);
    }

    public void afficher() {
        Noeud c = tete;
        while (c != null) {
            System.out.print(c.val + " ");
            c = c.suiv;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListeDoublementChainee l = new ListeDoublementChainee();
        
        l.ajouter(12);
        l.ajouter(4);
        l.ajouter(27);
        l.ajouter(1);
        l.ajouter(15);

        l.afficher();
        l.triBulles();
        l.afficher();
    }
}
