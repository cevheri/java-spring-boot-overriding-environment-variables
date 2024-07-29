import requests

# Create a new token in https://medium.com/me/settings/ > security and app > integration tokens
# get userId in https://api.medium.com/v1/me
# curl -H "Authorization: Bearer TOKEN" -H "Content-Type: application/json" -H "Accept: application/json" https://api.medium.com/v1/me | jq '.data.id'
# copy the id


MEDIUM_USER_ID = "USER_ID"
MEDIUM_API_URL = f"https://api.medium.com/v1/users/{MEDIUM_USER_ID}/posts"
MEDIUM_TOKEN = "TOKEN"
TITLE = "NLP Sentiment Analysis on Restaurant Reviews"
FILE_NAME = "nlp-sentiment-analysis-restaurant.md"


def main():
    headers = {
        "Authorization": f"Bearer {MEDIUM_TOKEN}",
        "Content-Type": "application/json",
        "Accept": "application/json",
        "Accept-Charset": "utf-8"
    }

    data = {
        "title": TITLE,
        "contentFormat": "markdown",
        "content": open(FILE_NAME, "r").read()
    }

    response = requests.post(MEDIUM_API_URL, headers=headers, json=data)

    if response.status_code == 201:
        print("Article published successfully!")
    else:
        print(f"Error: {response.status_code}")
        print(f"Error content: {response.content}")


if __name__ == "__main__":
    main()
