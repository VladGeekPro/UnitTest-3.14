public class CurrencyBinaryTree {
    public Node root;

    public Node getRoot() {
        return root;
    }

    public void insert(Currency currency) {
        Node newNode = new Node(currency);

        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;

            while (true) {
                parent = current;
                if (currency.getNumber() < current.currency.getNumber()) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public class Node {
        Currency currency;
        Node leftChild;
        Node rightChild;

        public Node(Currency currency) {
            this.currency = currency;
        }
    }

    public Currency find(int number) {
        Node current = root;
    
        while (current != null && current.currency.getNumber() != number) {
            if (number < current.currency.getNumber()) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }
    
        if (current == null) {
            return null;
        }
    
        return current.currency;
    }

    public boolean delete(int number) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
    
        while (current.currency.getNumber() != number) {
            parent = current;
    
            if (number < current.currency.getNumber()) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
    
            if (current == null) {
                return false;
            }
        }
    
      
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        }
        
        else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        }
        
        else {
            Node successor = getSuccessor(current);
    
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
    
            successor.leftChild = current.leftChild;
        }
    
        return true;
    }
    
    private Node getSuccessor(Node node) {
        Node successorParent = node;
        Node successor = node;
        Node current = node.rightChild;
    
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
    
        if (successor != node.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }
    
        return successor;
    }

    public void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.leftChild);
            System.out.println("cname1 : " + node.currency.getcname1()+"\n"+ "cname2 : " +  node.currency.getcname2()+"\n"+ "data : " +  node.currency.getdata()+"\n"+ "value : " +  node.currency.getvalue()+"\n"+ "number : " + node.currency.getNumber());
            System.out.println();
            inOrderTraversal(node.rightChild);
            
        }
    }

    public void reverseInOrderTraversal(Node node) {
        if (node != null) {
            reverseInOrderTraversal(node.rightChild);
            System.out.println("cname1 : " + node.currency.getcname1()+"\n"+ "cname2 : " +  node.currency.getcname2()+"\n"+ "data : " +  node.currency.getdata()+"\n"+ "value : " +  node.currency.getvalue()+"\n"+ "number : " + node.currency.getNumber());
            System.out.println();
            reverseInOrderTraversal(node.leftChild);
        }
    }
    
    public void symmetricOrderTraversal(Node node) {
        if (node != null) {
            
            symmetricOrderTraversal(node.leftChild);
            System.out.println("cname1 : " + node.currency.getcname1()+"\n"+ "cname2 : " +  node.currency.getcname2()+"\n"+ "data : " +  node.currency.getdata()+"\n"+ "value : " +  node.currency.getvalue()+"\n"+ "number : " + node.currency.getNumber());
            System.out.println();
            symmetricOrderTraversal(node.rightChild);
            
        }
    }
    
    
    
}
