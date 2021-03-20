package org.gregory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.MatcherAssert.*;

class BSTTest {
    BST<Integer> tree;
    BST<Integer> treeSorted;

    @BeforeEach
    void setUp() {
        tree = new BST<>(new BSTNode<>(5, 1, null));
        treeSorted = new BST<>(null);
    }

    @AfterEach
    void tearDown() {
        tree = null;
        treeSorted = null;
    }

    @Test
    void findNodeByKey() {
        add10ElementFrom0To10Excluding5();
        assertThat(tree.FindNodeByKey(4).getNode().getKey(), is(4));
    }

    @Test
    void addKeyValue_1Element_Right() {
        tree.AddKeyValue(20, 1);
        assertThat(tree.getRoot().getRightChild().getKey(), is(20));
        assertThat(tree.getRoot().getRightChild().getValue(), is(1));
    }

    @Test
    void addKeyValue_1Element_Left() {
        tree.AddKeyValue(1, 1);
        assertThat(tree.getRoot().getLeftChild().getKey(), is(1));
        assertThat(tree.getRoot().getLeftChild().getValue(), is(1));
    }

    @Test
    void finMinMax_10Elements_Min1() {
        add10ElementFrom0To10Excluding5();
        assertThat(tree.FinMinMax(tree.getRoot(), false).getKey(), is(0));
    }

    @Test
    void finMinMax_10Elements_Max10() {
        add10ElementFrom0To10Excluding5();
        assertThat(tree.FinMinMax(tree.getRoot(), true).getKey(), is(10));
    }

    private void add10ElementFrom0To10Excluding5() {
        for (int i = 0; i < 11; i++) {
            if (i == 5) {
                continue;
            }
            assertThat(tree.AddKeyValue(i, i), is(true));
        }
    }

    private void addElementsFrom0ToEndExcluding5(int end) {
        for (int i = 1; i <= end; i++) {
            if (i == 5) {
                continue;
            }
            assertThat(tree.AddKeyValue(i, i), is(true));
        }
    }

    @Test
    void deleteNodeByKey_deleteRoot() {
        assertThat(tree.DeleteNodeByKey(5), is(true));
        assertThat(tree.getRoot(), nullValue());
        assertThat(tree.FindNodeByKey(5).isNodeHasKey(), is(false));
        assertThat(tree.FindNodeByKey(5).getNode(), nullValue());
    }



    private void fillingTree() {
        assertThat(treeSorted.addArray(new BSTNode[]{
                new BSTNode(8, 1),
                new BSTNode(4, 1),
                new BSTNode(12, 1),
                new BSTNode(10, 1),
                new BSTNode(11, 1),
                new BSTNode(9, 1),
                new BSTNode(14, 1),
                new BSTNode(13, 1),
                new BSTNode(15, 1),
        }), is(true));
    }

    @Test
    void deleteNodeByKey_deleteLeafKey15() {
        fillingTree();
        assertThat(treeSorted.DeleteNodeByKey(15), is(true));
        assertThat(treeSorted.FindNodeByKey(15).isNodeHasKey(), is(false));
        assertThat(treeSorted.FindNodeByKey(15).getNode().getKey(), is(14));
    }

    @Test
    void FindNodeByKey_NodeDoesNotExist() {
        assertThat(treeSorted.FindNodeByKey(15).isNodeHasKey(), is(false));
    }

    @Test
    void deleteNodeByKey_delete1ChildKey14() {
        assertThat(treeSorted.addArray(new BSTNode[]{
                new BSTNode(8, 1),
                new BSTNode(4, 1),
                new BSTNode(12, 1),
                new BSTNode(10, 1),
                new BSTNode(11, 1),
                new BSTNode(9, 1),
                new BSTNode(14, 1),
                new BSTNode(15, 1),
        }), is(true));
        assertThat(treeSorted.DeleteNodeByKey(14), is(true));
        assertThat(treeSorted.FindNodeByKey(14).isNodeHasKey(), is(false));
        assertThat(treeSorted.FindNodeByKey(12).getNode().getRightChild().getKey(), is(15));
        assertThat(treeSorted.FindNodeByKey(15).getNode().getParent().getKey(), is(12));
    }

    @Test
    void deleteNodeByKey_2ChildrenKey12() {
        fillingTree();
        assertThat(treeSorted.DeleteNodeByKey(12), is(true));
        assertThat(treeSorted.FindNodeByKey(12).isNodeHasKey(), is(false));
        assertThat(treeSorted.FindNodeByKey(8).getNode().getRightChild().getKey(), is(13));
        assertThat(treeSorted.FindNodeByKey(13).getNode().getParent().getKey(), is(8));
        assertThat(treeSorted.FindNodeByKey(13).getNode().getRightChild().getKey(), is(14));
        assertThat(treeSorted.FindNodeByKey(14).getNode().getParent().getKey(), is(13));
    }

    @Test
    void count() {
        add10ElementFrom0To10Excluding5();
        assertThat(tree.Count(), is(11));
    }

    @Test
    void count_Add2_3Element() {
        addElementsFrom0ToEndExcluding5(2);
        assertThat(tree.Count(), is(3));
    }

    @Test
    void count_Add4_5Element() {
        addElementsFrom0ToEndExcluding5(4);
        assertThat(tree.Count(), is(5));
    }

    @Test
    void count_Add6_7Element() {
        addElementsFrom0ToEndExcluding5(7);
        assertThat(tree.Count(), is(7));
    }


}