import axios from "axios-observable/lib/axios";

export const httpClient = axios.create(
    {
        baseURL: "http://localhost:8080",
        responseType: 'json',
        headers: {
            'Content-Type': 'application/json'
        }
    }
);

export const getDataResponse = response => response.data;
