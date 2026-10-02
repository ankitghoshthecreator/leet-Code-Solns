class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes=preorder.split(",");

        int slot=1;

        for(String node:nodes){
            if(slot==0){
                return false;
            }
            slot--;

            if(!node.equals("#")){
                slot+=2;
            }
        }
        return slot==0;
    }
}