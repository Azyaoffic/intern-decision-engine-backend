# TICKET-101 Review Conclusion

## Requirements

The task for TICKET-101 was to implement an MVP decision engine with the following specifications:

- **Inputs:**
    - Personal code (string)
    - Loan amount (in euros)
    - Loan period (in months)
- **Outputs:**
    - Decision: "negative" or "positive"
    - Amount: the maximum loan amount approvable, regardless of the requested loan amount
- **Specific Scenarios:**
    - `49002010965`: has debt (negative decision, amount = 0)
    - `49002010976`: credit modifier = 100
    - `49002010987`: credit modifier = 300
    - `49002010998`: credit modifier = 1000
- **Constraints:**
    - Loan amount: €2000 to €10,000
    - Loan period: 12 to 48 months
- **Logic:**
    - If the person has debt, return a negative decision with amount = 0.
    - Otherwise, calculate the maximum approvable amount as `min(10000, credit_modifier * loan_period)`.
    - If `credit_modifier * loan_period < 2000`, try a fallback period (e.g., 48 months) and recalculate.
    - Decision is "positive" if the maximum amount is ≥ €2000; otherwise, "negative" with amount = 0.

The goal was to validate this implementation and assess it against these requirements, focusing on functionality and code quality.

## What Was Done Well

- **Documentation**: Every method contains Javadoc, making it easier to understand the code
- **Separated constants**: Allows for easy change of limits from within a single file
- **SOLID principles**: The code is well-structured and follows the SOLID principles (e.g., every calculation is in a separate method)
- **Exception handling**: The code handles exceptions and returns an error message in the response. There are multiple types of exceptions, each responsible for a different error scenario.
- **Unit tests**: Code contains unit tests for all the main logic, such as segmentation, exception handling etc.
- **Use of Lombok**: Makes code cleaner and easier to read by reducing boilerplate code

## What Was Done Poorly
- **Too many requests**: The client code sends request at each change of the sliders, which can lead to unnecessary requests. While this is fine for the selection of the loan amount, period selection only changes values in steps of 6, resulting in 6 identical requests being sent.
  - This, in my opinion, was the biggest issue with the code and that was fixed in the client-side codebase.
- **Score categories do not match examples**: All codes provided in example end up in the same category, which is not the intended solution. It is unclear whether those examples are part of requirements or not (i.e. whether the solution should be able to handle them).
- **Wrong maximum period constant**: The maximum period constant is set to 60, while the requirements state that the maximum period is 48 months.
- **Maximum sum**: The maximum sum is limited by what the user inputs, which might be lower than the maximum sum that can be approved. Per requirements we should return the maximum sum that can be approved, regardless of the user input.
- **Iterative maximum period calculation**: The code uses iteration to calculate the maximum period instead of using a formula. While this works, this is not effective.
  - Also, this is one of the few calculations that is not in a separate method.

## Conclusion
The code effectively meets the core requirement of determining the maximum approvable sum with period adjustments, handling constraints, and providing a usable API. However, discrepancies in credit modifier assignment, partial scoring algorithm adherence, and a minor period limit issue suggest areas for refinement. Most issues stem from requirement ambiguities (e.g., examples vs. logic), so aligning these would solidify the implementation.