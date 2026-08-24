import pandas as pd

def market_analysis(users: pd.DataFrame, orders: pd.DataFrame, items: pd.DataFrame) -> pd.DataFrame:
    orders["order_date"] = pd.to_datetime(orders["order_date"])

    result = users.merge(
        orders,
        left_on="user_id",
        right_on="buyer_id",
        how="left"
    )

    result["orders_in_2019"] = (
        result["order_date"].dt.year == 2019
    )

    result = (
        result.groupby(["user_id", "join_date"], as_index=False)
        ["orders_in_2019"]
        .sum()
    )

    result = result.rename(columns={
        "user_id": "buyer_id"
    })

    return result