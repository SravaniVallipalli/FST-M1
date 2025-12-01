# Parameterization
import pytest

@pytest.mark.parametrize("earned, spent, expected", [(30, 10, 20),(20, 2, 18)])
def test_balance(wallet, earned, spent, expected):
    # Add the earned money
    wallet += earned
    # Subtract the earned money
    wallet -= spent
    # Check final balance
    assert wallet == expected