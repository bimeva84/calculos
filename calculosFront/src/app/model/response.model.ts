/**
 * Interfaz para el manejo de respuesta de los servicios del Back
 */
export interface ResponseService{
    /** Error generado en el consumo del servicio */
    error: string,
    /** Estado de ejecución del servicio */
    status: number,
    /** Datos generados al consumir el servicio */
    body: any,
}