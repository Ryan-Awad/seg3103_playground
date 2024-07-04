defmodule Grades.Calculator do
  def percentage_grade(%{homework: homework, labs: labs, midterm: midterm, final: final}) do
    avg_homework = avg(homework)
    avg_labs = avg(labs)

    mark = calculate_grade(avg_labs, avg_homework, midterm, final)
    round(mark * 100)
  end

  def letter_grade(%{homework: homework, labs: labs, midterm: midterm, final: final}) do
    avg_homework = avg(homework)
    avg_labs = avg(labs)

    avg_exams = (midterm + final) / 2

    num_labs = get_num_labs(labs)

    if failed_to_participate(avg_homework, avg_exams, num_labs) do
      "EIN"
    else
      mark = calculate_grade(avg_labs, avg_homework, midterm, final)
      grade_scale = ["F","E","D","D+","C","C+","B","B+","A-","A","A+"]
      get_grade_symbol(mark, grade_scale)
    end
  end

  def numeric_grade(%{homework: homework, labs: labs, midterm: midterm, final: final}) do
    avg_homework = avg(homework)
    avg_labs = avg(labs)

    avg_exams = (midterm + final) / 2

    num_labs = get_num_labs(labs)

    if failed_to_participate(avg_homework, avg_exams, num_labs) do
      0
    else
      mark = calculate_grade(avg_labs, avg_homework, midterm, final)
      grade_scale = [0,1,2,3,4,5,6,7,8,9,10]
      get_grade_symbol(mark, grade_scale)
    end
  end

  # Helper method for finding the average of a set of grades. If an empty set of grades is provided, the outputted average is 0.
  def avg(grades) do
    if Enum.count(grades) == 0 do
      0
    else
      Enum.sum(grades) / Enum.count(grades)
    end
  end

  # Helper method that just acts as a clean abstraction layer over the condition inside the function.
  def failed_to_participate(avg_homework, avg_exams, num_labs) do
    avg_homework < 0.4 || avg_exams < 0.4 || num_labs < 3
  end

  # Helper method that calculates your final grade
  def calculate_grade(avg_labs, avg_homework, midterm, final) do
    0.2 * avg_labs + 0.3 * avg_homework + 0.2 * midterm + 0.3 * final
  end

  # Helper method that returns the number of labs with a mark >= 0.25
  def get_num_labs(labs) do
    labs
      |> Enum.reject(fn mark -> mark < 0.25 end)
      |> Enum.count()
  end

  # Helper method that returns a grade symbol given a grade and a defined grade scale
  def get_grade_symbol(mark, grade_scale) do
    cond do
      mark > 0.895 -> Enum.at(grade_scale, 10)
      mark > 0.845 -> Enum.at(grade_scale, 9)
      mark > 0.795 -> Enum.at(grade_scale, 8)
      mark > 0.745 -> Enum.at(grade_scale, 7)
      mark > 0.695 -> Enum.at(grade_scale, 6)
      mark > 0.645 -> Enum.at(grade_scale, 5)
      mark > 0.595 -> Enum.at(grade_scale, 4)
      mark > 0.545 -> Enum.at(grade_scale, 3)
      mark > 0.495 -> Enum.at(grade_scale, 2)
      mark > 0.395 -> Enum.at(grade_scale, 1)
      :else -> Enum.at(grade_scale, 0)
    end
  end
end
