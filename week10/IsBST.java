boolean checkBST(Node root) {
    return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
}

boolean checkBST(Node tmp, int minVal, int maxVal) {
    if (tmp == null) {
        return true;
    }

    if (tmp.data <= minVal || tmp.data >= maxVal) {
        return false;
    }

    return checkBST(tmp.left, minVal, tmp.data) && checkBST(tmp.right, tmp.data, maxVal);
}