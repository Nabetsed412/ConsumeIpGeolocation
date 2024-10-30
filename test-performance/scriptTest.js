import http from 'k6/http';
import { check, sleep } from 'k6';

export let options = {
    stages: [
        { duration: '10s', target: 5 },
        { duration: '20s', target: 5 },
        { duration: '10s', target: 0 },
    ],
};

export default function () {
    let res = http.get('http://api:8080/api/geolocation/stats'); // URL de tu API
    check(res, {
        'is status 200': (r) => r.status === 200,
    });
    sleep(1);
}
