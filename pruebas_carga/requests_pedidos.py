import requests
import time
from concurrent.futures import ThreadPoolExecutor, as_completed

# Configuración
URLS = [
    'http://localhost:8080/pedido'
]  # Lista de URLs a probar
CONCURRENCY = 10  # Número de solicitudes simultáneas
REQUESTS_PER_URL = 100  # Número de solicitudes por URL


def measure_response_time(url):
    """Realiza una solicitud HTTP y mide el tiempo de respuesta."""
    start_time = time.time()
    try:
        data= {
                  "fecha": "2024-11-27",
                  "lineas": [
                    { "producto": "prod-001", "cantidad": 2 },
                    { "producto": "prod-002", "cantidad": 1 },
                    { "producto": "prod-003", "cantidad": 5 }
                  ]
                }
        response = requests.post(url, json=data, timeout=10)
        end_time = time.time()
        return {
            "url": url,
            "status_code": response.status_code,
            "response_time": round((end_time - start_time) * 1000, 2)  # ms
        }
    except requests.exceptions.RequestException as e:
        return {"url": url, "error": str(e), "response_time": None}


def main():
    results = []
    start_time = time.time()
    with ThreadPoolExecutor(max_workers=CONCURRENCY) as executor:
        futures = []
        for _ in range(REQUESTS_PER_URL):
            for url in URLS:
                futures.append(executor.submit(measure_response_time, url))

        # Procesar las respuestas a medida que se completan
        for future in as_completed(futures):
            results.append(future.result())

    total_time = time.time() - start_time

    # Mostrar resultados
    print(f"\nResultados tiempo total {total_time} ")
    print(f'\nTotal de consultas: {REQUESTS_PER_URL}, concurrencia: {CONCURRENCY}')
    for result in results:
        if "error" in result:
            print(f"URL: {result['url']} - Error: {result['error']}")
        else:
            print(f"URL: {result['url']} - Código: {result['status_code']} - Tiempo: {result['response_time']} ms")


if __name__ == "__main__":
    main()
