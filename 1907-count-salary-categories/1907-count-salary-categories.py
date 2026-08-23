import pandas as pd

def count_salary_categories(accounts: pd.DataFrame) -> pd.DataFrame:
    def categorize(income):
        if income < 20000:
            return "Low Salary"
        elif income <= 50000:
            return "Average Salary"
        else:
            return "High Salary"

    accounts["category"] = accounts["income"].apply(categorize)

    result = (
        accounts["category"]
        .value_counts()
        .reindex(
            ["Low Salary", "Average Salary", "High Salary"],
            fill_value=0
        )
        .reset_index()
    )

    result.columns = ["category", "accounts_count"]

    return result