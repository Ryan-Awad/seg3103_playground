# Lab 2

## Exercise 1

| Testcase    | Expected Results | Actual Results | Verdict (Pass, Fail, Inconclusive) |
| -------- | ------- | -------- | -------- |
| Username: John123 <br> First name: John <br> Last name: Doe <br> Email: example@test.com <br> Age: 24 <br> City: Ottawa <br> Postal code: K1N 1N2  | Valid registration    |  Registration valid    |  Pass    |
| Username: 123John <br> First name: John <br> Last name: Doe <br> Email: example@test.com <br> Age: 24 <br> City: Ottawa <br> Postal code: K1N 1N2  | Wrong UserName format    |  Wrong UserName format |  Pass    |
| Username: John123 <br> First name: 123 <br> Last name: Doe <br> Email: example@test.com <br> Age: 24 <br> City: Ottawa <br> Postal code: K1N 1N2  | Wrong FirstName format    |  Wrong FirstName format |  Pass    |
| Username: John123 <br> First name: John <br> Last name: 123 <br> Email: example@test.com <br> Age: 24 <br> City: Ottawa <br> Postal code: K1N 1N2  | Wrong LastName format    |  Wrong LastName format |  Pass    |
| Username: John123 <br> First name: John <br> Last name: Doe <br> Email: example <br> Age: 24 <br> City: Ottawa <br> Postal code: K1N 1N2  | Wrong Email format    |  Wrong Email format |  Pass    |
| Username: John123 <br> First name: John <br> Last name: Doe <br> Email: example@test.com <br> Age: abc <br> City: Ottawa <br> Postal code: K1N 1N2  | Wrong Age format    |  	Failed to convert property value of type java.lang.String to required type java.lang.Integer for property age; nested exception is java.lang.NumberFormatException: For input string: "abc" |  FAIL    |
| Username: John123 <br> First name: John <br> Last name: Doe <br> Email: example@test.com <br> Age: 17 <br> City: Ottawa <br> Postal code: K1N 1N2  | 	must be greater than or equal to 18    |  		must be greater than or equal to 18 |  Pass    |

## Screenshots

![testcases](assets/tcs.png) 