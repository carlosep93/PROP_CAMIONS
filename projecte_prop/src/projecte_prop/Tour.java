
package projecte_prop;


import java.util.List;
import java.util.ArrayList;

/*import Stubs.Relations;
import Stubs.CtrlDomini;*/

public class Tour {
    private int nElements, cost;
    List<Punt> cjtElem;
    
    
    /** @brief Constructora de la classe Tour
\pre
\post S'inicialitza el conjunt d'elements
*/
    public Tour(){
        cjtElem = new ArrayList<Punt>();
        nElements = 0;
        cost = -1;
    }
    
    public Tour(Tour t){
        this.nElements = t.size();
        for(int i = 0; i < nElements; ++i){
            this.cjtElem.add(i, t.getElementPos(i));
        }
    }
    
    public void setCjtElem(List<Punt> llp){
        for(int i = 0; i < llp.size(); ++i){
            addElement(llp.get(i));
        }
    }
    
    /** @brief Afegeix un objecte Element al l'objecte Tour
\pre L'element no sigui buit i l'element E no està al Tour
\post S'ha afegit l'Element E a la última posició del Tour
*/
    public void addElement(Punt E){
        cjtElem.add(E);
        ++nElements;
        cost = -1;
    }
    
    /** @brief Afegeix l'element E a la pos p
\pre L'element E està dins del Tour, i la posició pos és una posició vàlida(0 a nElements)
\post S'ha afegit l'element E a la posició pos del Tour, si hi havia un element a la posició pos s'afegeix davant d'aquest
*/
    public void addElement(Punt E, int pos){
        cjtElem.add(pos, E);
        ++nElements;
        cost = -1;
    }
    
    /** @brief Elimina l'Element amb identificador igual a id del Tour
\pre L'Element amb identificador id està dins del Tour
\post Busca al Tour l'Element que tingui el mateix identificador que id i l'elimina
*/
    public void removeElement(int id){
        for(int i = 0; i < nElements; ++i){
            if(cjtElem.get(i).getID() == id){
                cjtElem.remove(i);
                break;
            }
        }
        --nElements;
        cost = -1;
    }
    
    /** @brief Elimina l'element en la posició
\pre El Tour te la posició pos
\post S'ha esborrat l'Element E de la posició pos
*/
    public void removeElementPos(int pos){
        cjtElem.remove(pos);
        --nElements;
        cost = -1;
    }
    
    /** @brief Esborra l'Element del Tour que el seu nom sigui igual al paràmetre nom
\pre El Tour contè un Element el qual el seu nom és igual a nom
\post S'ha esborrat l'Element el qual el seu nom és igual a nom
*/
    public void removeElement(String nom){
        for(int i = 0; i < nElements; ++i){
            if(cjtElem.get(i).getNom().equals(nom)){
                cjtElem.remove(i);
                break;
            }
        }
        --nElements;
        cost = -1;
    }
    
    /** @brief Inhabilita l'Element de la posició pos
\pre Existeix un Element a la posició pos
\post L'Element de la posició pos ha estat inhabilitat(s'ha posat el paràmetre Enabled de l'element a false)
*/
    public void inhabilitaElement(int pos){
        cjtElem.get(pos).modifyEnabled(false);
    }
    
    /** @brief Substitueix l'Element de Tour amb identificador igual a id per l'Element E1
\pre El Tour no contè l'Element E i no contè un Element amb identificador igual a id
\post L'Element del Tour amb identificador id ha estat substituït per l'element E
*/
    public void replaceElementId(Punt E, int id){
        int pos = getPosElement(id);
        cjtElem.remove(pos);
        cjtElem.add(pos, E);
        cost = -1;
    }
    
    /** @brief Substitueix l'Element de la posició pos per l'Element E
\pre El Tour contè l'Element de la posició pos
\post S'ha esborrat l'Element de la posició pos i s'ha afegit al seu lloc l'Element E
*/
    public void replaceElementPos(Punt E, int pos){
        cjtElem.remove(pos);
        cjtElem.add(pos, E);
        cost = -1;
    }
    
    /** @brief Substitueix l'Element amb el nom i és substitueix per E
\pre El Tour contè un Element amb nom igual a nom
\post S'ha esborrat l'Element amb nom igual a nom i s'ha afegit a la seva posició l'Element E
*/
    public void replaceElement(Punt E, String nom){
        for(int i = 0; i < nElements; ++i){
            if(cjtElem.get(i).getNom().equals(nom)){
                cjtElem.remove(i);
                cjtElem.add(i, E);
                break;
            }
        }
        cost = -1;
    }
    
    /** @brief Comprova si hi ha un element al Tour amb identificador id
\pre
\post Retorna true si Tour contè un element amb identificador id altrament false
*/
    public boolean containsElement(int id){
        boolean trobat = false;
        for(int i = 0; i < nElements; ++i){
            if(cjtElem.get(i).getID() == id){
                trobat = true;
                break;
            }
        }
        return trobat;
    }
    
    /** @brief Comprova si hi ha un element al Tour amb nom
\pre
\post Retorna true si Tour contè un element amb nom igual a nom altrament false
*/
    public boolean containsElement(String nom){
        boolean trobat = false;
        for(int i = 0; i < nElements; ++i){
            if(cjtElem.get(i).getNom().equals(nom)){
                trobat = true;
                break;
            }
        }
        return trobat;
    }
    
    /** @brief Obtè un Element a partir de la posició
\pre Tour contè la posició pos
\post Retorna l'Element de la posició pos dins del Tour
*/
    public Punt getElementPos(int pos){
        return cjtElem.get(pos);
    }
    
    /** @brief Obtè l'Element amb nom igual a nom
\pre Tour contè un Element amb nom igual a nom
\post Retorna la posició de l'Element amb nom igual a nom
*/
    public Punt getElementNom(String nom){
        Punt E = cjtElem.get(0);
        for(int i = 0; i < nElements; ++i){
            if(cjtElem.get(i).getNom().equals(nom)){
                E = cjtElem.get(i);
                System.out.println(E.getNom());
                break;
            }
        }
        return E;
    }
    
    /** @brief Obté l'Element a partir de l'id d'una altre Element
\pre
\post Si existeix un Element amb l'identificador id retorna la seva posició altrament retorna -1
*/
    public int getPosElement(int id){
        int pos = -1;
        for(int i = 0; i < nElements; ++i){
            if(cjtElem.get(i).getID() == id){
                pos = i;
                break;
            }
        }
        return pos;
    }
    
    /** @brief Fa swap de dos Elements del Tour
\pre Existeixen dos Elements els quals els seus identificadors són id1 i id2, i aquests són diferents
\post S'han intercanviat les posicions entre els Elements del Tour que els seus identificadors són id
*/
    public void swapId(int id1, int id2){
        int pos1, pos2;
        pos1 = getPosElement(id1);
        pos2 = getPosElement(id2);
        Punt E1, E2;
        E1 = getElementPos(pos1);
        E2 = getElementPos(pos2);
        replaceElementPos(E1,pos2);
        replaceElementPos(E2,pos1);
        cost = -1;
    }
    
    /** @brief Fa swap de dos Elemets del Tour
\pre Les posicions pos1 i pos2 són vàlides dins del Tour
\post S'ham intercanviat les posicions entre els Elements del Tour que les seves posicions fòssin pos1 i pos2
*/
    public void swap(int pos1, int pos2){
        Punt E1, E2;
        E1 = getElementPos(pos1);
        E2 = getElementPos(pos2);
        replaceElementPos(E1, pos2);
        replaceElementPos(E2, pos1);
        cost = -1;
    }
    
    /** @brief Funció per sonultar el nombre d'Elements del Tour
\pre
\post Retorna el nombre d'elements continguts al Tour
*/
    public int size(){
        return nElements;
    }
    
    /** @brief Retorna el cost de recòrrer el Tour
\pre
\post Retorna el cost de recòrrer tots els Elements del Tour en l'ordre
*/
    public int getCost(City C){
        if(cost == -1){
            if (nElements == 0 || nElements == 1) return 0;
            else{
                cost = 0;
                for(int i = 0; i < nElements-1; ++i){
                    cost += C.getCost(cjtElem.get(i), cjtElem.get(i+1));
                }
                cost += C.getCost(cjtElem.get(0),cjtElem.get(nElements-1));
            }

        }
        return cost;
    }
    
    public List<Punt> getCjtElements(){
        return cjtElem;
    }
    
    public ArrayList<String> getNomElements(){
        ArrayList<String> noms = new ArrayList<String>();
        for (int i=0; i<cjtElem.size(); ++i) noms.add(cjtElem.get(i).getNom());
        return noms;
    }
}