defmodule Grades.CalculatorTest do
  use ExUnit.Case
  alias Grades.Calculator

  describe "percentage_grade/1" do
    test "sample" do
      assert 85 == Calculator.percentage_grade(%{homework: [0.8], labs: [1, 1, 1], midterm: 0.70, final: 0.9})
    end

    test "handles empty homework and labs, with zero midterm and final" do
      assert Calculator.percentage_grade(%{homework: [], labs: [], midterm: 0, final: 0}) == 0
    end

    test "calculates percentage grade with single element lists for homework and labs" do
      assert Calculator.percentage_grade(%{homework: [0.10], labs: [0.10], midterm: 0.10, final: 0.10}) == 10
    end

    test "calculates percentage grade with multiple elements in lists" do
      assert Calculator.percentage_grade(%{homework: [0.80, 0.90], labs: [0.70, 0.80], midterm: 0.75, final: 0.85}) == 81
    end
  end

  describe "letter_grade/1" do
    test "returns EIN when all inputs are zero" do
      assert Calculator.letter_grade(%{homework: [], labs: [], midterm: 0, final: 0}) == "EIN"
    end

    test "returns EIN when avg_homework is below threshold" do
      assert Calculator.letter_grade(%{homework: [0.50], labs: [0.50], midterm: 0.50, final: 0.50}) == "EIN"
    end

    test "returns correct letter grade for valid inputs" do
      assert Calculator.letter_grade(%{homework: [0.80, 0.90], labs: [0.70, 0.80, 0.90], midterm: 0.75, final: 0.85}) == "A-"
    end

    test "returns correct letter grade for low number of labs" do
      assert Calculator.letter_grade(%{homework: [0.80, 0.90], labs: [0.60], midterm: 0.75, final: 0.85}) == "EIN"
    end
  end

  describe "numeric_grade/1" do
    test "returns zero when all inputs are zero" do
      assert Calculator.numeric_grade(%{homework: [], labs: [], midterm: 0, final: 0}) == 0
    end

    test "returns zero when avg_homework is below threshold" do
      assert Calculator.numeric_grade(%{homework: [0.50], labs: [0.50], midterm: 0.50, final: 0.50}) == 0
    end

    test "returns correct numeric grade for valid inputs" do
      assert Calculator.numeric_grade(%{homework: [0.80, 0.90], labs: [0.70, 0.80, 0.90], midterm: 0.75, final: 0.85}) == 8
    end

    test "returns correct numeric grade for low number of labs" do
      assert Calculator.numeric_grade( %{homework: [0.80, 0.90], labs: [0.60], midterm: 0.75, final: 0.85}) == 0
    end
  end
end
