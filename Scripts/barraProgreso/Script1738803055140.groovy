import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// Abrir el navegador y navegar al sitio web
WebUI.openBrowser('https://demoqa.com/automation-practice-form')
WebUI.delay(2)
// Navegar a la sección "Widgets" y luego a "Progress Bar"
WebUI.click(findTestObject('Object Repository/Page_DEMOQA/div_Widgets'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/Page_DEMOQA/span_progress_bar'))
WebUI.delay(2)
// Hacer clic en el botón "Start" para iniciar la carga de la barra
WebUI.click(findTestObject('Object Repository/Page_DEMOQA/button_Start'))

// Monitorear la barra de progreso hasta que alcance el 39%
def targetPercentage = 39
def currentPercentage = 0

while (true) {
    // Obtener el valor del atributo 'aria-valuenow'
    def progressValue = WebUI.getAttribute(findTestObject('Object Repository/Page_DEMOQA/progressBar'), 'aria-valuenow')
   
    // Convertir el valor a entero
    currentPercentage = progressValue.toInteger()
    
    // Detener el bucle si el progreso alcanza o supera el 39%
    if (currentPercentage >= targetPercentage) {
        // Presionar el botón "Stop" inmediatamente
        WebUI.click(findTestObject('Object Repository/Page_DEMOQA/button_Stop'))
        break
    }
    
    // Esperar un breve momento antes de verificar nuevamente (reducido a 5 ms)
    WebUI.delay(0.005) // Tiempo mínimo para evitar sobrecargar el sistema
}

// Cerrar el navegador
WebUI.closeBrowser()
