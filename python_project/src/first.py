
from selenium import webdriver
from selenium.webdriver.common.by import By

driver_path = 'C:\chromedriver'
email = "......"
password = "......."
url = 'https://decisiel-webapp-staging.azurewebsites.net/decisiel/login'

driver = webdriver.Chrome()
driver.get(url)

email_field = driver.find_element("name", "email")
password_field = driver.find_element("name", "password")

email_field.send_keys(email)
password_field.send_keys(password)

login_button = driver.find_element(By.CLASS_NAME, "btn")
login_button.click()

# Garder le navigateur ouvert
while True :
    input("Press Enter to close the browser...")

# Fermer le navigateur
# driver.quit()
