from math_operations import div

def test_div():
    assert div(6, 3) == 2
    assert div(7, 2) == 3
    assert div(-7, 2) == -4
    assert div(0, 1) == 0