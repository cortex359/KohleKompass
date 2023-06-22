import azure.functions as func
import openai
import logging

app = func.FunctionApp()

# Learn more at aka.ms/pythonprogrammingmodel

# Get started by running the following code to create a function using a HTTP trigger.

@app.function_name(name="azure_aoi_keyword_generator")
@app.route(route="kk")
def test_function(req: func.HttpRequest) -> func.HttpResponse:
    logging.info('Python HTTP trigger function processed a request.')

    name = req.params.get('name')
    if not name:
        try:
            req_body = req.get_json()
        except ValueError:
            pass
        else:
            name = req_body.get('name')

    openai.api_type = "azure"
    openai.api_base = "<api endpoint>"
    openai.api_version = "2023-03-15-preview"
    openai.api_key = "<api_key>"

    response = openai.ChatCompletion.create(
        engine="Gpt35Turbo",
        messages=[{"role": "system", "content": "You are an AI that gets request from a mobile app and gives quick responses in csv, no explanations and no other text than the requested data. In the App, users document their expenses and associate tags with expenses in order to categorize them. When a User enters a new expense in the app, matching tags are suggested to the user. This possible because each tag has a set of keywords that are compared with the user input. If a keyword matches, the corresponding tag is suggested to the user. Keywords are subterms and umbrella terms of the tag title, as well as activities, venues, shops with which the tag title could be associated. It is your task to generate such keywords for such tags. I will give you the title of the tag and you will give me 20 keywords."},
            {"role": "user", "content": "bills"},
            {"role": "assistant", "content": "bill,payment,utilities,electricity,internet,heating,gez,contract,phone,"},
            {"role": "user", "content": "entertainment"},
            {"role": "assistant", "content": "movie,tickets,cinema,weekend,event,cineplex,show,circus,AMC,Cineworld,Disneyworld,Phantasialand,funfair,netflix,spotify,apple,music,prime,amazon,"},
            {"role": "user", "content": "gas"},
            {"role": "assistant", "content": "gas,gasoline,fuel,refill,petrol,aral,shell,agip,gas,esso,BP,ENI,Total"},
            {"role": "user", "content": "groceries"},
            {"role": "assistant", "content": "groceries,grocery,supermarket,store,food,shopping,aldi,lidl,kaufland,penny,netto"},

            {"role": "user", "content": name}
],
    temperature=0.7,
    max_tokens=800,
    top_p=0.95,
    frequency_penalty=0,
    presence_penalty=0,
    stop=None)

    result = response.choices[0].message.content

    if name:
        return func.HttpResponse(result)
    else:
        return func.HttpResponse(
            "No name passed with request",
            status_code=200
        )
