from math_operations import sub

def test_sub():
    assert sub(5, 3) == 2
    assert sub(-3, -2) == -1
    assert sub(0, 5) == -5
    assert sub(3, 3) == 0
