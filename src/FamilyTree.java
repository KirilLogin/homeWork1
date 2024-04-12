package Family_Tree;
import java.util.ArrayList;
import java.util.List;

    public class FamilyTree {
        private long countPeople; //Лучше перенести в main
        List<Human> HumanList;

        public FamilyTree(){this(new ArrayList<>());}

        public FamilyTree( List<Human> HumanList){this.HumanList = HumanList;}

        public boolean add(Human human) {
            if (human == null) {
                return false;
            }
            if (!HumanList.contains(human)) {
                HumanList.add(human);
                human.setID(countPeople++);
                addToParents(human);
                addToChildren(human);
                return true;
            }
            return false;
        }
        private void addToParents(Human human){
            for(Human parent: human.getParents()){
                parent.addChild(human);
            }
        }
        private void addToChildren(Human human){
            for(Human child: human.getChildren()){
                child.addParents(human);
            }
        }
        public Human getID(long id){
            for(Human human: HumanList){
                if(human.getID() == id){
                    return human;
                }
            }
            return null;
        }
        /*public List<Human> getSib(int id){   Разобраться в методе(нахождение братьев и сестер)
            Human human = getID(id);
            if(human == null){
                return null;
            }
            List<Human> res = new ArrayList<>();
            for(Human parent: human.getParents()){
                for(Human child: human.getChildren()){
                    if(!child.equals(human)){
                        res.add(child);
                    }
                }
            }
            return res;
        }*/
        @Override
        public String toString(){
            return getInfo();
        }
        public String getInfo(){
            StringBuilder sc = new StringBuilder();
        }

    }
